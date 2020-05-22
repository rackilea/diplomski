public void actionPerformed(ActionEvent arg0) {
    try {
        table.setModel(loadData());
    } catch (ClassNotFoundException | SQLException | IOException ex) {
        ex.printStackTrace();
    }
    DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
    centerRenderer.setHorizontalAlignment(JLabel.CENTER);
    table.getColumnModel().getColumn(0).setHeaderValue("Nazwa panstwa");
    table.getColumnModel().getColumn(1).setHeaderValue("Przychod netto USD");
    table.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
    table.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
}