primaryStage.setTitle("Update Stuff");

Label lbl = new Label();
lbl.setText("Nothing here yet");

Button btn = new Button();
btn.setText("Update");
btn.setOnAction(new EventHandler<ActionEvent>() {

    @Override
    public void handle(ActionEvent event) {
        btn.setDisable(true);
        new Thread(()->{
            final String numberOfViews =  getNumberOfViewers();
            Platform.runLater(()->{
                lbl.setText(numberOfViews);
                btn.setDisable(false);
            });                   
        }).start();
        lbl.setText(getNumberOfViewers()); // this might take a few seconds, need to disable button during this time
    }
});

VBox root = new VBox();
root.setAlignment(Pos.CENTER);
root.getChildren().addAll(btn, lbl);
primaryStage.setScene(new Scene(root, 200, 100));
primaryStage.show();