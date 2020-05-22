table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

        @Override
        public void valueChanged(ListSelectionEvent e) {

            int row =  table.convertRowIndexToModel(table.getSelectedRow());
            int col = table.getColumnModel().getColumnIndex("AUTO-ID");

            int auto_id = (Integer) table.getModel().getValueAt(row, col);
                 // assuming that `m.getId()` is returning `int` 
                //while adding with addRow() function
        }
    });