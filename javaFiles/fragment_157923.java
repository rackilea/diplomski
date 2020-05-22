public void start(Stage primaryStage) throws IOException {
            primaryStage.setTitle("Title");
            primaryStage.setScene(createScene(loadMainPane("path_of_your_fxml")));
            primaryStage.show();

    }

    private Pane loadMainPane(String path) throws IOException {
        FXMLLoader loader = new FXMLLoader();

        Pane mainPane = (Pane) loader.load(
                getClass().getResourceAsStream(path));

        return mainPane;
    }


    private Scene createScene(Pane mainPane) {
        Scene scene = new Scene(mainPane);
      return scene;
    }
    public static void main(String[] args) {launch(args); }