@FXML Pane pane1;
. . .
GraphScene scene = new DemoGraphScene();
. . .
SwingNode swingScene = new SwingNode();
swingScene.setContent(scene.getView());
. . .
pane1.getChildren().add(swingScene);