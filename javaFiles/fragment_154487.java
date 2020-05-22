FXMLLoader loader = new FXMLLoader(getClass().getResource("ServerConfigChooser.fxml"));
    ServerConfigChooser controller = new ServerConfigChooser();
    loader.setController(controller);
    loader.setRoot(controller);
    Parent root;
    try {
        root = (Parent) loader.load();
        Scene scene = new Scene(root, 320, 200);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    } catch (IOException ex) {
        Logger.getLogger(ServerConfigChooser.class.getName()).log(Level.SEVERE, null, ex);
    }