ImageView errorView = new ImageView();
errorView.setImage(new Image("error.png"));
CustomTextField searchField = new CustomTextField();
searchField.setRight(errorView);
searchField.textProperty().addListener((observable, oldValue, newValue) -> {
    if (!newValue.matches("\\d*")) {
        searchField.setText(newValue.replaceAll("[^\\d]", ""));
        searchField.setStyle("-fx-text-box-border: red; -fx-focus-color: red ;");
        errorView.setVisible(true);
    }else if(!searchField.getStyle().equals("")){
        searchField.setStyle("");
        errorView.setVisible(false);
    }
});