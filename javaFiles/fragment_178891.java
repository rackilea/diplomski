Button btSave = new Button();
btSave.setText("Add");
btSave.setOnAction(new EventHandler<ActionEvent>() {
    @Override
    public void handle(ActionEvent event) {                

        //SCENE 3 OF 3: ADD SCENE, Pane & Nodes
        GridPane addPane = new GridPane();

        //add nodes
        addPane.add(new Label("Customer Name"), 1,1);
        addPane.add(tfName, 1,2);
        addPane.add(new Label("Size of Party"), 1,3);
        addPane.add(tfParty, 1,4);
        addPane.add(new Label("Customer Phone Number"), 1,5);
        addPane.add(tfPhone, 1,6);
        addPane.add(btSave, 1, 7);

        Stage addStage = new Stage();
        Scene addScene = new Scene(addPane, 300, 250);
        addStage.setTitle("Add Customer to Queue");
        addStage.setScene(addScene);
        addStage.show();
    }
});