public class ColumnAlignmentRenderer implements TableCellRenderer {

    private TableCellRenderer mWrappedRenderer;
    private int mDefaultAlignment = SwingConstants.LEFT;
    private Map<Integer, Integer> mSpecialColumnAlignmentMap = new Hashtable<Integer, Integer>();

    public ColumnAlignmentRenderer(TableCellRenderer pWrappedRenderer) {
        mWrappedRenderer = pWrappedRenderer;
    }

    public Component getTableCellRendererComponent(JTable pTable, Object pValue, boolean pIsSelected,
            boolean pHasFocus, int pRow, int pColumn) {

        // Use the wrapped renderer
        Component renderedComponent = mWrappedRenderer.getTableCellRendererComponent(pTable, pValue, pIsSelected, pHasFocus,
                pRow, pColumn);

        // Set the alignment
        Integer alignment = mSpecialColumnAlignmentMap.get(pColumn);
        if (alignment != null) {
            ((JLabel)renderedComponent).setHorizontalAlignment(alignment);
        } else {
            ((JLabel)renderedComponent).setHorizontalAlignment(mDefaultAlignment);
        }

        return renderedComponent;
    }

    public void setSpecialColumnAlignment(Integer pColumn, Integer pAlignment) {
        mSpecialColumnAlignmentMap.put(pColumn, pAlignment);
    }

    public void setDefaultAlignment(int pAlignment) {
        mDefaultAlignment = pAlignment;
    }
}