myStatusColumn.setCellFactory(new Callback<TableColumn<Task, String>, TableCell<Task, String>>() {
        @Override
        public TableCell<Task, String> call(TableColumn<Task, String> param) {
            ComboBox<String> box = new ComboBox<>();
            TableCell<Task, String> cell = new TableCell<Task, String>() {

                @Override
                protected void updateItem(String item, boolean empty) {
                    if (empty)
                        setGraphic(null);
                    else {
                            setEditable(false);
                            setText(item);
                    }
                }
            };
            cell.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    if(event.getButton().equals(MouseButton.PRIMARY))
                    {
                         Task task = myTasksTable.getSelectionModel().getSelectedItem();
                        if(task!=null)
                            box.setItems(FXCollections.observableArrayList(task.getStatuses()));
                        cell.setEditable(true);
                    }
                    if(event.getClickCount()==2 && cell.isEditable() ) {
                        box.getSelectionModel().select(0);
                        cell.setText(null);
                        cell.setGraphic(box);
                    }

                }
            });

            cell.setOnKeyPressed(new EventHandler<KeyEvent>() {
                @Override
                public void handle(KeyEvent event) {
                    if(event.getCode().equals(KeyCode.ENTER))
                    {
                        try {
                            TaskLog taskLog = (TaskLog) myTasksTable.getSelectionModel().getSelectedItem();
                            if(taskLog != null) {
                                taskLog.setStatues(box.getSelectionModel().getSelectedItem());
                                taskLog.setStatuesID(Login.dbHandler.getStatusID(taskLog.getStatues()));
                                System.out.println(taskLog.getStatues());
                                Login.dbHandler.addNewTaskLog(taskLog);
                                cell.setEditable(false);
                                myTasksTable.refresh();
                            }
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
            return cell;
        }
    });