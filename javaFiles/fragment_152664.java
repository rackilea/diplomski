outline.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
    @Override
    public void valueChanged(ListSelectionEvent e) {
        int row = outline.getSelectedRow();
        File f = (File) outline.getValueAt(row, 0);
        if (!e.getValueIsAdjusting()) {
            System.out.println(row + ": " + f);
        }
    }
});