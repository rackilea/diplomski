for(int i = 0; i < (Runner.times).size(); i++) {
        String time = Runner.times.get(i);
        final int index = i;
        TableColumn<Object, String> timesCol = new TableColumn<Object, String>(time);
        timesCol.setCellValueFactory(createCellValueCallback(i + 1));

        timesCol.setCellFactory(tc -> {
            TableCell<Object, String> cell = new TableCell<Object, String>() {
                @Override
                protected void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    setText(item);
                }
            };

            cell.setOnMouseClicked(event -> {
                if (! cell.isEmpty()) {
                    System.out.println("Click on column "+index+", row "+cell.getIndex());
                }
            });
            return cell ;
        });

        timesCol.setSortable(false);

        tableView.getColumns().add(timesCol);
    }