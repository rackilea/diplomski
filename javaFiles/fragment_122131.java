private class CellRenderer extends DefaultTableCellRenderer
{

 public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
 {
    JLabel label = new JLabel((String)value);
    label.setOpaque(true);
    Icon icon = new ImageIcon("icon.png");
    label.setIcon(icon);
    return label;
 }
}