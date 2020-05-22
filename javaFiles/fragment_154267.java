for (int i = 0; i < clms; i++) {
        TableColumn<String[], String> firstNameCol = new TableColumn<>("\tC"+(i+1)+" \t");
        firstNameCol.setMinWidth(20);
        int index = i ;
        firstNameCol.setCellValueFactory(cellData -> {
            String[] rowData = cellData.getValue();
            if (index >= rowData.length) {
                return new ReadOnlyStringWrapper("");
            } else {
                String cellValue = rowData[index];
                return new ReadOnlyStringWrapper(cellValue);
            }
        });
        sourceTable.getColumns().add(firstNameCol);
    }