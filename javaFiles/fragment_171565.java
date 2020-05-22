public class Bar {
    public void createUI(Pane parent) {
        BorderPane pane = new BorderPane();
        Button btn = new Button("hey");
        pane.setCenter(btn);

        parent.getChildren().add(pane);
    }
}