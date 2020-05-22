JXTable table = new JXTable(model);
final ChangeDecorator controller = new ChangeDecorator();
table.addHighlighter(controller.getChangeHighlighter());
TableModelListener l = new TableModelListener() {

    @Override
    public void tableChanged(TableModelEvent e) {
        if (TableUtilities.isUpdate(e)) {
            Change change = new Change(e.getFirstRow(), e.getColumn());
            controller.addChange(change);
        } else if (TableUtilities.isInsert(e)) {
            Change change = new Change(e.getFirstRow());
            controller.addChange(change);
        }
    }
};
model.addTableModelListener(l);



/**
 * Manages the Highlighters for inserted rows/updated cells.
 */
public static class ChangeDecorator {

    private List<Change> changes;
    private AbstractHighlighter update;
    private AbstractHighlighter insert;
    private Highlighter compound;

    public ChangeDecorator() {
        changes = new ArrayList<>();
    }

    public Highlighter getChangeHighlighter() {
        if (compound == null) {
            update = new ColorHighlighter(new ChangePredicate(changes, true), 
                    Color.YELLOW, null);
            insert = new ColorHighlighter(new ChangePredicate(changes, false), 
                    Color.GREEN, null);
            compound = new CompoundHighlighter(update, insert);
        }
        return compound;
    }

    public void addChange(Change change) {
        startTimer(change, change.isCell ? update : insert);
    }

    private void startTimer(final Change change, final AbstractHighlighter hl) {
        changes.add(change);
        hl.setHighlightPredicate(new ChangePredicate(changes, change.isCell));
        ActionListener l = new ActionListener() {
            boolean done;
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!done) {
                    done = true;
                    return;
                }
                ((Timer) e.getSource()).stop();
                changes.remove(change);
                hl.setHighlightPredicate(new ChangePredicate(changes, change.isCell));
            }

        };
        Timer timer = new Timer(2000, l);
        timer.setInitialDelay(100);
        timer.start();
    }
}

/**
 * A predicate enables highlighting a cell if it
 * contains a change for that cell. 
 */
public static class ChangePredicate implements HighlightPredicate {

    private List<Change> changes;
    private boolean matchCell;
    public ChangePredicate(List<Change> changes, boolean matchCell) {
        this.changes = new ArrayList(changes);
        this.matchCell = matchCell;
    }

    @Override
    public boolean isHighlighted(Component renderer,
            ComponentAdapter adapter) {
        return changes.contains(createChange(adapter));
    }

    private Change createChange(ComponentAdapter adapter) {
        int modelRow = adapter.convertRowIndexToModel(adapter.row);
        if (matchCell) {
            int modelColumn = 
                    adapter.convertColumnIndexToModel(adapter.column);;
                    return new Change(modelRow, modelColumn);
        }
        return new Change(modelRow);
    }

}

/**
 * A crude class encapsulating a cell change. 
 * 
 */
public static class Change {
    int row;
    int column;
    boolean isCell;

    public Change(int row) {
        this(row, -1, false);
    }

    public Change(int row, int col) {
        this(row, col, true);
    }

    private Change(int row, int col, boolean update) {
        this.row = row;
        this.column = col;
        this.isCell = update;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Change)) return false;
        Change other = (Change) obj;
        return row == other.row && column == other.column && isCell == other.isCell;
    }

}