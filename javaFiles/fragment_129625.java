addButton.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        if (table.getModel().getRowCount() == 2) {
            return;
        }
        Object[][] data = new Object[table.getModel().getRowCount() + 1][5];
        table.setRowSorter(null);
        for (int i = 0; i <= table.getModel().getRowCount(); i++) {
            data[i][0] = i;
            data[i][6] = "User" + i;
            data[i][7] = "Delete";
        }
        table.setModel(new CustModel(data));
        table.setAutoCreateRowSorter(true);
    }
});