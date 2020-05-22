JTable table = new JTable( model ) {
    public Component prepareRenderer( TableCellRenderer renderer, int row, int column) {
        JComponent jc = (JComponent)super.prepareRenderer(renderer, row, column);
        jc.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        return jc;
    }
};