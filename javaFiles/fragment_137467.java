class TextAreaRenderer implements TableCellRenderer {

    private JTextArea renderer;
    private final Color evenColor = new Color(252, 248, 202);

    public TextAreaRenderer() {
        renderer = new JTextArea();            
        renderer.setLineWrap(true);
        renderer.setWrapStyleWord(true);
        renderer.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        if (isSelected) {
            renderer.setForeground(table.getSelectionForeground());
            renderer.setBackground(table.getSelectionBackground());
        } else {
            renderer.setForeground(table.getForeground());
            renderer.setBackground((row % 2 == 0) ? evenColor : table.getBackground());
        }            
        renderer.setFont(table.getFont());
        renderer.setText((value == null) ? "" : value.toString());
        JPanel contentPane = new JPanel(new BorderLayout());            
        contentPane.add(renderer);
        table.setRowHeight(row, contentPane.getPreferredSize().height); // sets row's height
        return contentPane;
    }

}