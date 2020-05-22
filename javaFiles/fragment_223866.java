@SuppressWarnings("serial")
class MyRenderer extends DefaultTableCellRenderer {
    private static final int ALPHA = 60;
    private Color chefColor;
    private Color defaultColor;

    public MyRenderer(Color chefColor, Color defaultColor) {
        this.chefColor = chefColor;
        this.defaultColor = defaultColor;
        setOpaque(true);
        setHorizontalAlignment(SwingConstants.CENTER);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
            boolean hasFocus, int row, int column) {
        Component superComp = super.getTableCellRendererComponent(table, value, isSelected,
                hasFocus, row, column);
        if (value != null) {
            MyTableModel tableModel = (MyTableModel) table.getModel();
            boolean chef = tableModel.getEmployee(row).isChef();
            Color c = chef ? chefColor : defaultColor;
            if (!hasFocus && !isSelected) {
                c = new Color(c.getRed(), c.getGreen(), c.getBlue(), ALPHA);
            } 

            superComp.setBackground(c);
        }
        return superComp;
    }
}