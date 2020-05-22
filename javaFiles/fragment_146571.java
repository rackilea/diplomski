public void setUpSportColumn(JTable table,
                TableColumn sportColumn) {
    //Set up the editor for the sport cells.
    JComboBox comboBox = new JComboBox();
    DefaultComboBoxModel model = new DefaultComboBoxModel();
    model.addElement("Snowboarding");
    model.addElement("Rowing");
    model.addElement("Knitting");
    model.addElement("Speed reading");
    model.addElement("Pool");
    model.addElement("None of the above");
    comboBox.setModel(model);
    sportColumn.setCellEditor(new DefaultCellEditor(comboBox));

    model = new DefaultComboBoxModel();
    model.addElement("Snowboarding");
    model.addElement("Rowing");
    model.addElement("Knitting");
    model.addElement("Speed reading");
    model.addElement("Pool");
    model.addElement("None of the above");
    //Set up tool tips for the sport cells.
    ComboBoxTableCellRenderer renderer
                    = new ComboBoxTableCellRenderer();
    renderer.setModel(model);
    sportColumn.setCellRenderer(renderer);
}