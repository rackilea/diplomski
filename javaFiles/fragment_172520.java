TableView.setRowFactory((tv) -> {
    TableRow<Row> row = new TableRow<Person>() {

        @Override
        public void updateItem(Person person, boolean empty) {
            super.updateItem(person, empty);

            switch (person.getPersonStatus()) {
              case ST:
                setStyle("-fx-control-inner-background: " + StatusColor.B_LIGHT.getMyColorValue() + "; -fx-text-fill: #fff;");
                break;
              case CD:
                setStyle("-fx-control-inner-background: " + StatusColor.D_LIGHT.getMyColorValue() + "; -fx-text-fill: #fff;");
                break;
            }
        }
    };
    row.setOnMouseClicked(event -> {
        if (event.getClickCount() == 2 && (!row.isEmpty())) {
          Person rowData = row.getItem();
          System.out.println(rowData);
        }
    });
    return row;
});