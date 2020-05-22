FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/simplygoals/view/RemoveUser.fxml"));

// this line causes RemoveUserController.initialize() to be called:
Parent root2 = (Parent) fxmlLoader.load();

Stage stage = new Stage();
stage.setResizable(false);
stage.setTitle("Remove User");
stage.setScene(new Scene(root2));
RemoveUserController removeUserController = fxmlLoader.getController();

// mainControl is not initialized in removeUserController until you do this:
removeUserController.setMainControl(this);