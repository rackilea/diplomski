JTable table = new JTable() {
    public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
        Component c = super.prepareRenderer(renderer, row, column);
        if (c instanceof JComponent) {
           if(column == X){
            //X is your particlur column number

            JComponent jc = (JComponent) c;
            jc.setToolTipText(getValueAt(row, column).toString());
           }
        }
        return c;
    }
};