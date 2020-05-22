@Override
public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocused, int row, int column) {

    Component comp = delegate.getTableCellRendererComponent(table, value, isSelected, hasFocused, row, column);
    JPanel panel = new JPanel(new BorderLayout());
    if (comp instanceof JLabel) {
        JLabel label = (JLabel) comp;
        label.setBackground(Color.WHITE);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(label);
        panel.setBorder(lb);
    }
    return panel;
}