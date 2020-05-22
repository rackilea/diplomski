Hyperlink link = new Hyperlink("TEST");
link.setOnAction(new EventHandler<ActionEvent>() {
    @override public void handle(ActionEvent e) {
                Stage stage = new Stage();
                TextArea text = new TextArea():

                VBox vbox = new VBox();
                Button close = new Button();
                close.setText("Close");
                close.setOnAction(new EventHandler<ActionEvent>() {
                    @Override public void handle(ActionEvent e) {
                        stage.close();
                    }
                });
                vbox.getChildren().addAll(text, close);
                Scene scene = new Scene(vbox);

                stage.setScene(scene);
                stage.setMinWidth(100);
                stage.setMinHeight(100);
                stage.show();
                // ...
                text.setText("update");
    }
});