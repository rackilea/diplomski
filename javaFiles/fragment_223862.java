class MyRenderer extends DefaultTableCellRenderer {
    private Color chefColor;
    private Color defaultColor;

    public MyRenderer(Color chefColor, Color defaultColor) {
        this.chefColor = chefColor;
        this.defaultColor = defaultColor;
        setOpaque(true);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
            boolean hasFocus, int row, int column) {
        Component superComp = super.getTableCellRendererComponent(table, value, isSelected,
                hasFocus, row, column);

        // here test if row holds a chef item
        // if so, set background color to chefColor
        // otherwise set background color to the defaultColor.
        return superComp;
    }
}