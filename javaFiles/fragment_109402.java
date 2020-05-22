public class SectionedTable
extends JTable {
    private static final long serialVersionUID = 1;

    private final NavigableMap<Integer, String> sectionHeadings =
                                                        new TreeMap<>();

    private final NavigableMap<Integer, Integer> rowTopEdges =
                                                        new TreeMap<>();

    // Used when calling SwingUtilities.layoutCompoundLabel.
    private final Rectangle iconBounds = new Rectangle();
    private final Rectangle textBounds = new Rectangle();

    public SectionedTable() {
        init();
    }

    public SectionedTable(TableModel model) {
        super(model);
        init();
    }

    private void init()
    {
        setShowGrid(false);
        setAutoCreateRowSorter(true);

        recomputeSections();
        recomputeRowPositions();
    }

    private void recomputeSections() {
        if (sectionHeadings == null) {
            return;
        }

        sectionHeadings.clear();

        RowSorter<? extends TableModel> sorter = getRowSorter();
        if (sorter == null) {
            return;
        }

        for (RowSorter.SortKey key : sorter.getSortKeys()) {
            SortOrder order = key.getSortOrder();
            if (order != SortOrder.UNSORTED) {
                int sortColumn = key.getColumn();

                String lastSectionStart = "";
                int rowCount = getRowCount();
                for (int row = 0; row < rowCount; row++) {
                    Object value = getValueAt(row, sortColumn);
                    if (value == null) {
                        value = "?";
                    }

                    String s = value.toString();
                    if (s.isEmpty()) {
                        s = "?";
                    }

                    String sectionStart = s.substring(0,
                        s.offsetByCodePoints(0, 1));
                    sectionStart = sectionStart.toUpperCase();

                    if (!sectionStart.equals(lastSectionStart)) {
                        sectionHeadings.put(row, sectionStart);
                        lastSectionStart = sectionStart;
                    }
                }
                break;
            }
        }
    }

    private void recomputeRowPositions() {
        if (rowTopEdges == null) {
            return;
        }

        rowTopEdges.clear();

        int y = getInsets().top;
        int rowCount = getRowCount();
        int rowHeight = getRowHeight();
        for (int row = 0; row < rowCount; row++) {
            rowTopEdges.put(y, row);
            y += getRowHeight(row);
            if (sectionHeadings.containsKey(row)) {
                y += rowHeight;
            }
        }
    }

    @Override
    public void tableChanged(TableModelEvent event) {
        recomputeSections();
        recomputeRowPositions();
        super.tableChanged(event);
    }

    @Override
    public void sorterChanged(RowSorterEvent event) {
        recomputeSections();
        recomputeRowPositions();
        super.sorterChanged(event);
    }

    @Override
    public void validate() {
        super.validate();
        recomputeRowPositions();
    }

    @Override
    public int rowAtPoint(Point location) {
        Map.Entry<Integer, Integer> entry = rowTopEdges.floorEntry(location.y);
        if (entry != null) {
            int row = entry.getValue();
            return row;
        }
        return -1;
    }

    @Override
    public Rectangle getCellRect(int row,
                                 int column,
                                 boolean includeSpacing) {

        Rectangle rect = super.getCellRect(row, column, includeSpacing);

        int sectionHeadingsAbove = sectionHeadings.headMap(row, true).size();
        rect.y += sectionHeadingsAbove * getRowHeight();

        return rect;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        boolean ltr = getComponentOrientation().isLeftToRight();

        int rowHeight = getRowHeight();
        FontMetrics metrics = g.getFontMetrics();
        int ascent = metrics.getAscent();
        for (Map.Entry<Integer, String> entry : sectionHeadings.entrySet()) {
            int row = entry.getKey();
            String heading = entry.getValue();

            Rectangle bounds = getCellRect(row, 0, true);
            bounds.y -= rowHeight;
            bounds.width = getWidth();
            bounds.grow(-6, 0);

            iconBounds.setBounds(0, 0, 0, 0);
            textBounds.setBounds(0, 0, 0, 0);
            String text = SwingUtilities.layoutCompoundLabel(this,
                metrics, heading, null,
                SwingConstants.CENTER, SwingConstants.LEADING,
                SwingConstants.CENTER, SwingConstants.CENTER,
                bounds, iconBounds, textBounds, 0);

            g.drawString(text, textBounds.x, textBounds.y + ascent);

            int lineY = textBounds.y + ascent / 2;
            if (ltr) {
                g.drawLine(textBounds.x + textBounds.width + 12, lineY,
                                  getWidth() - getInsets().right - 12, lineY);
            } else {
                g.drawLine(textBounds.x - 12, lineY,
                                  getInsets().left + 12, lineY);
            }
        }
    }
}