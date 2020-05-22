@FXML
private void openLoginPrompt() {
    try {
        Stage loginStage = new Stage();
        // Load root layout from fxml file.
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(ChatApplication.class.getResource("LoginPrompt.fxml"));
        AnchorPane rootLayout = (AnchorPane) loader.load();

        LoginController loginController = loader.getController();
        loginController.loggedInProperty().addListener((obs, wasLoggedIn, isNowLoggedIn) -> {
            if (isNowLoggedIn) {
                loginStage.hide();
            }
        });

        // Show the scene containing the root layout.
        Scene scene = new Scene(rootLayout);
        loginStage.setScene(scene);
        loginStage.show();

    } catch (IOException e) {
        e.printStackTrace();
    }
}