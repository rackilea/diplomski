public class MovieSearchResultTable extends BaseTable {

    private static final long serialVersionUID = 45L;

    private int rolloverRowIndex = -1;

    public MovieSearchResultTable(TableModel tableModel) {
        super(tableModel);
        LibraryLogger.initMessage(getClass().getSimpleName());
    }   

    public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
        Component component = super.prepareRenderer(renderer, row, column);
        Color foreground = getForeground();
        Color background = getBackground();
        if (isRowSelected(row)) {
            foreground = getSelectionForeground();
            background = getSelectionBackground();
        }
        else if (row == rolloverRowIndex) {
            foreground = getSelectionForeground();
            background = ColorHelper.brighter(getSelectionBackground(), 40);
        }
        else if (row % 2 == 0) {
            background = ColorHelper.brighter(getParent().getBackground(), 20);
        }
        component.setForeground(foreground);
        component.setBackground(background);
        return component;
    }

    private class RolloverListener extends MouseInputAdapter {

        public void mouseExited(MouseEvent e) {
            rolloverRowIndex = -1;
            repaint();
        }

        public void mouseMoved(MouseEvent e) {
            int row = rowAtPoint(e.getPoint());
            if (row != rolloverRowIndex) {
                rolloverRowIndex = row;
                repaint();
            }
        }
    }

    @Override
    public void initialize() {
        setFillsViewportHeight(true);
        setAutoResizeMode(AUTO_RESIZE_OFF);
        TableColumnModel tableColumnModel = getColumnModel();
        for(ComponentConstant.ColumnName columnName : ComponentConstant.Column.MOVIE_SEARCH_RESULT_TABLE) {
            int order = columnName.getOrder();
            TableColumn tableColumn = tableColumnModel.getColumn(order); 
            if(order == 0) {
                continue;
            }

            tableColumn.setCellRenderer(RendererFactory.getMovieSearchResultTableCellRenderer());
        }
        RolloverListener listener = new RolloverListener();
        addMouseMotionListener(listener);
        addMouseListener(listener);
    }

    @Override
    public boolean getScrollableTracksViewportWidth() {
        return getPreferredSize().getWidth() < getParent().getWidth();
    }
}