private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {
        DefaultTableModel model = (DefaultTableModel) annoTab.getModel();
        TableColumn valueColumn = annoTab.getColumnModel().getColumn(1);
        CustomTableCellEditor customEditor = new CustomTableCellEditor();
        for (Entry<String, HashSet<String>> avar : Annotation.resultSet.entrySet()) {
            Object[] row = new Object[2];
            row[0] = avar.getKey();
        //Edit to set the first value in hashset as defaultvalue;
            row[1]=avar.getValue().iterator().next();

            model.addRow(row);
            setUpValueColumn(valueColumn, customEditor, avar.getValue());
        }
        valueColumn.setCellEditor(customEditor);
    }

    public void setUpValueColumn(TableColumn sportColumn, CustomTableCellEditor customEditor, HashSet<String> values) {
        customEditor.addComboBox(new JComboBox(new DefaultComboBoxModel(values.toArray())));
        ComboBoxTableCellRenderer renderer = new ComboBoxTableCellRenderer();
        sportColumn.setCellRenderer(renderer);
    }