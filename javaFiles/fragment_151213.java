@FXML
    public void buttonClick(javafx.event.ActionEvent actionEvent) {
        bottomController = main.getBottomController();
        System.out.println("Some Stuff..");
        bottomController.setLabelText("Some Stuff..");
    }