JTable table = new JTable();
JButton button = new JButton();
button.setEnabled(false);

ListSelectionModel listSelectionModel = table.getSelectionModel();
listSelectionModel.addListSelectionListener(new ListSelectionListener() {
        public void valueChanged(ListSelectionEvent e) { 
            ListSelectionModel lsm = (ListSelectionModel)e.getSource();
            button.setEnabled(!lsm.isSelectionEmpty());
});