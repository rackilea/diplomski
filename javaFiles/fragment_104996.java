Action delete = new AbstractAction("Delete Selected Row") {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (table.getSelectedRow() < 0) return;
            int modelRowIndex = table.convertRowIndexToModel(table.getSelectedRow());
            ((DefaultTableModel) table.getModel().removeRow(modelRowIndex);
        }
    };
    JButton button = new JButton(delete);