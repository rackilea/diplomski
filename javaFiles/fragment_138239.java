button1.setOnAction(e -> {
    // Create any hierarchy of nodes you want here
    HBox root = new HBox(new Label("Hello new stage"));

    // Create a new stage and and a scene to hold your root node
    Stage newStage = new Stage();
    newStage.setScene(new Scene(root));

    // Show the new stage
    newStage.show();
});