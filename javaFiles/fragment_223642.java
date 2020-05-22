table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

    @Override
    public void valueChanged(ListSelectionEvent e) {
          // Last selected row:
          table.getSelectedRow(); // -1 if no row selected
          // All selected rows:
          table.getSelectedRows();

    }
});