@Override
public Component getTableCellRendererComponent(...) {
    ...
    JPanel contentPane = new JPanel(new BorderLayout());            
    contentPane.add(this);
    table.setRowHeight(row, contentPane.getPreferredSize().height); // sets row's height
    return contentPane;
}