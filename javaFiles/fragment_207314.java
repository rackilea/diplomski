fadeOut.setOnFinished((e) -> {
    try {               
        Parent root2 = FXMLLoader.load(getClass().getResource("../view/fxml/Welcome.fxml"));

        scene.setRoot(root2);

    } catch (IOException e1) {
        e1.printStackTrace();
    }
});