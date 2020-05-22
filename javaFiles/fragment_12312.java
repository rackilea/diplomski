@Override
  public void valueChanged(ListSelectionEvent event) {
    ListSelectionModel listSelectionModel = ( ListSelectionModel ) event.getSource();
    listSelectionModel.removeListSelectionListener( this );
    model.setRowCount(0);
    model.addRow(new Object[]{"1", "2", "3"});
    model.addRow(new Object[]{"4", "2", "3"});
    model.addRow(new Object[]{"3", "2", "3"});
    model.addRow(new Object[]{"2", "2", "3"});
    listSelectionModel.addListSelectionListener( this );
  }