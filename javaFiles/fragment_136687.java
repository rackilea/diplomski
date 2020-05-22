private void createScene(String[] columnNames, String[][] inputData) {

    TableView<List<String>> table = new TableView<>();

    table.setEditable(false);

    for (int i = 0; i < columnNames.length; i++) {

        TableColumn<List<String>, String> column = new TableColumn<>(columnNames[i]);

        final int colIndex = i ;
        column.setCellValueFactory(cellData -> 
            new SimpleStringProperty(cellData.getValue().get(colIndex)));

        table.getColumns().add(column);

    }

    List<List<String>> data = new ArrayList<List<String>>();

    for (int i = 0; i < inputData.length; i++) {
        List<String> row = new ArrayList<String>();
        for (int j = 0; j < inputData[0].length; j++) {

            row.add(inputData[i][j]);

        }

        data.add(row);

    }

    ObservableList<List<String>> inpData = FXCollections.observableArrayList(data);



    table.setItems(inpData); 

    table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

    VBox vbox = new VBox();
    vbox.setSpacing(5);
    vbox.setPadding(new Insets(10, 0, 0, 10));
    vbox.getChildren().add(table);

    Scene scene = new Scene(vbox, 500, 500);
    jfxPanel.setScene(scene);

}