public JTextField createFormattedField() {
    JTextField txt = new JTextField();
    txt.setForeground(Color.WHITE);
    txt.setEditable(false);
    txt.setColumns(10);
    txt.setBorder(null);
    txt.setBackground(Color.GRAY);    
    return txt;
}