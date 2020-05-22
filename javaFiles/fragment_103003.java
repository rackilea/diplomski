if(count == 1){
    FXMLLoader loader = new FXMLLoader(getClass().getResource("second.fxml"));
    AnchorPane pane = loader.load();
    SecondController controller = (SecondController) loader.getController();
    controller.updateUsernameText(username_text);
    rootpane.getChildren().setAll(pane);
    System.out.println("User Found, Logged in");
}