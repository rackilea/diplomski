//Initialize Group root for Main Node
    Group root = new Group();

    //Initialize Scene on group root with specific sizes
    Scene scene = new Scene(root, 450, 250);

    //Initialize BorderPane and Bind the layout with the scene size.
    BorderPane borderPane = new BorderPane();
    borderPane.prefHeightProperty().bind(scene.heightProperty());
    borderPane.prefWidthProperty().bind(scene.widthProperty());

    //Set the TabPane to be centered
    borderPane.setCenter(tabPane);

    //Adds Layout to Main Node
    root.getChildren().add(borderPane);