public void goToDestination(String destination, String username, Privilege privilege) throws IOException {
 FXMLLoader loader = new FXMLLoader(getClass().getResource("../../resources/fxml/" + destination + ".fxml"));
 Parent root = loader.load();

 ParentController controller = loader.getController();
 controller.setUsername(username);
 controller.setPrivilege(privilege);

 stage.setTitle("Yuconz System");
 stage.setScene(new Scene(root));
 stage.setMaximized(true);
 stage.show();
}