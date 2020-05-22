FXMLLoader loader = new FXMLLoader();
    Parent node = loader.load(getClass().getResource("myfxml.fxml")).openStream());
    Scene scene = new Scene(node);
    Stage stage = new Stage();
    MyController controller = (MyController)loader.getController();

    stage.setTitle(titleString);
    stage.setScene(scene);
    stage.setOnHidden(event -> {
    //do all your processing here
         controller.doSaveHere();
    });
    stage.show();