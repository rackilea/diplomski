TextField headerTextField = new TextField();
Label label = new Label("First Name");
VBox headerGraphic = new VBox();
headerGraphic.setAlignment(Pos.CENTER);
headerGraphic.getChildren().addAll(label, headerTextField);

TableColumn<Person, String> firstNameCol = new TableColumn<>();
firstNameCol.setGraphic(headerGraphic);