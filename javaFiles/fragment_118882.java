public void populateTable() {
    boolean firstTime = (model == null);

    if (firstTime) {
        initializeModel();
    } else {
        model.getDataVector().clear();
    }

    for (Health item : health.showAllData()) {
        model.addRow(new Vector<>(Arrays.asList(
                item.getZipCode(), item.getCounty(), item.getState(), item.getYear(),
                item.getMonth(), item.getAgeGroup(), item.getNumOfVisits(),
                item.getMMax(), item.getMMin(), item.getMNor()
        )));
    }

    if (firstTime && table != null) {
        table.setModel(model);
    }
}

private void initializeModel() {
    model = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            //all cells false
            return false;
        }
    };

    for (String name : columnNames)
        model.addColumn(name);
}