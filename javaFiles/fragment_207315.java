fadeOut.setOnFinished((e) -> {
    try {               
        Parent root2 = FXMLLoader.load(getClass().getResource("../view/fxml/Welcome.fxml"));

        Scene scene2 = new Scene(root2, scene.getWidth(), scene.getHeight());

        stage.setScene(scene2);
    } catch (IOException e1) {
        e1.printStackTrace();
    }
});