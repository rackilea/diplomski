JFXTreeTableColumn<User, String> settingsColumn = new JFXTreeTableColumn<>("Others");
        settingsColumn.setPrefWidth(100);
        Callback<TreeTableColumn<User, String>, TreeTableCell<User, String>> cellFactory
                = //
                new Callback<TreeTableColumn<User, String>, TreeTableCell<User, String>>() {
                    @Override
                    public TreeTableCell call(final TreeTableColumn<User, String> param) {
                        final TreeTableCell<User, String> cell = new TreeTableCell<User, String>() {

                            final JFXButton btn = new JFXButton("Just Do it");

                            @Override
                            public void updateItem(String item, boolean empty) {
                                super.updateItem(item, empty);
                                if (empty) {
                                    setGraphic(null);
                                    setText(null);
                                } else {
                                    btn.setButtonType(JFXButton.ButtonType.RAISED);
                                    btn.setOnAction(event -> {
                                    //Button Action here
                                    });
                                    setGraphic(btn);
                                    setText(null);
                                }
                            }
                        };
                        return cell;
                    }
                };

settingsColumn.setCellFactory(cellFactory);

//Also remember to add the new column in
treeView.getColumns().setAll(deptColumn, ageColumn, empColumn, settingsColumn);