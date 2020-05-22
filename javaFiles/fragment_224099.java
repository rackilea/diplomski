EventHandler<ActionEvent> onFinished = e->{
   mainStage = primaryStage;
   mainStage.setScene(new loginScene());
   mainStage.show();
};
KeyFrame keyFrame = new KeyFrame(new Duration(3000), onFinished ,keyValue);