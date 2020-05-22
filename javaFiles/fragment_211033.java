@FXML private ComboBox<Type> target;
@FXML private VBox targetBox;   

@FXML public void onTargetSelected() {
    targetBox.getChildren().clear();
    for(Indicator indic : target.getValue().getIndics()) {
        VBox box = new VBox();

        Text t = new Text(indic.getLabel());
        box.getChildren().add(t);

        TextField txt = new TextField();
        txt.setMaxWidth(target.getWidth());
        box.getChildren().add(txt);

        targetBox.getChildren().add(box);
    }
    Controller.stage.close();
    Controller.stage.show();
}