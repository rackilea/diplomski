TableView<String> tableView = new TableView<>();
    tableView.setRowFactory(cb -> {
        TableRow<String> row = new TableRow<>();
        row.setOnMouseClicked(ev -> {
            if(ev.getClickCount() > 1) {

            }
        });
        return row;
    });