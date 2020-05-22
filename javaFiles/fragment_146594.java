ChoiceBox<String> colorChoice = new ChoiceBox<>(
            FXCollections.observableArrayList("Red", "Blue", "Green", "Yellow", "Pink", "Grey", "Black", "White"));

    colorChoice.setOnAction(new EventHandler<ActionEvent>() {
        public void handle(ActionEvent e) {

            String choice = colorChoice.getSelectionModel().getSelectedItem() ;
            if (choice != null) {
                String color = choice.toLowerCase();
                colorChoice.setStyle("-fx-base: "+color+"; -fx-control-inner-background: -fx-base ;");
                text.setFill(Color.web(color));
            }
        }
    });