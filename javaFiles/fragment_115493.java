private void createTextField() {
        textField = new TextField(getString());
        textField.setStyle("-fx-padding 1px 1px 1px 1px;-fx-font-size: 10pt;");
        //or another way
        textField.setPadding(new Insets(0,0,0,5));
        textField.setFont(new Font(8));