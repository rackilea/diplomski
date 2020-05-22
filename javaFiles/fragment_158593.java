private static void makeScene(Stage primaryStage, Node searchRoot, Node addRoot, Node viewRoot){

    final int WIDTH = 500;
    final int HEIGHT = 600;

    BorderPane root = new BorderPane();

    final Scene scene = new Scene(root, WIDTH, HEIGHT);


    HBox navBar = new HBox(15);
    Button searchButton = new Button("Search People");
    Button addButton    = new Button("Add Person");
    Button viewButton   = new Button("View People");

    navBar.getChildren().addAll(searchButton, addButton, viewButton);
    navBar.setAlignment(Pos.CENTER);
    navBar.setPrefHeight(42);

    root.setTop(navBar);

    searchButton.setOnAction((ActionEvent event) -> {
        System.out.println("Search Button Pressed");
        root.setCenter(searchRoot);
    });
    addButton.setOnAction((ActionEvent event) -> {
        System.out.println("Add Button Pressed");
        root.setCenter(addRoot);
    });
    viewButton.setOnAction((ActionEvent event) -> {
        System.out.println("Soup");
        root.setCenter(viewRoot);
    });

    primaryStage.setScene(scene);
}