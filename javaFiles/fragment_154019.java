private final Group group = new Group();
private final VBox vbox = new VBox();
private final Button button = new Button("Click");
private final Label label = new Label("Slider Value: ");

@Override
public void start(Stage primaryStage) {
    vbox.getChildren().addAll(button, label, new Slider(0,10,4));
    vbox.setSpacing(20);
    group.getChildren().add(vbox);

    button.setOnAction(e->{
        Node nodeOut = group.getChildren().get(0);
        if(nodeOut instanceof VBox){
            for(Node nodeIn:((VBox)nodeOut).getChildren()){
                if(nodeIn instanceof Slider){
                    label.setText("Slider value: "+((Slider)nodeIn).getValue());
                }
            }

        }      
    });
    Scene scene = new Scene(group, 300, 250);
    primaryStage.setScene(scene);
    primaryStage.show();
}