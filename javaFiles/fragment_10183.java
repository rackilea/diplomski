// JTable Colouring Class
class CustomRenderer extends DefaultTableCellRenderer 
{
    private List<Color> desiredColors = new ArrayList<Color>();

    public void setColors(Color incomingColor)
    {
        desiredColors.add(incomingColor);
    }

    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
    {
        Component cellComponent = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        for (int i = 0; i < desiredColors.size(); i++) {
            if(row == i){
                cellComponent.setBackground(desiredColors.get(i));
            }
        }
        return cellComponent;
    }
}