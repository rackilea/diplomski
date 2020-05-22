public class PopupTest extends Application {

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) {
        Group root = new Group();
        Scene scene = new Scene(root, 800, 600);

        Button btn = new Button("Display Popup");
        btn.setOnMouseClicked(new PopupOpenEvent(stage));
        root.getChildren().add(btn);

        stage.setTitle("Popup demo");
        stage.setScene(scene);
        stage.show();
        //stage.setVisible(true);       
    }

    class PopupOpenEvent implements EventHandler<MouseEvent> {

        private Stage stage;

        PopupOpenEvent(Stage s){
            stage = s;
        }

        @Override
        public void handle(MouseEvent e) {
            Popup popup = new Popup();

            HBox box = new HBox();
            box.getChildren().add(new Label("In popup..."));
            box.setPrefSize(100, 100);
            box.setAlignment(Pos.BOTTOM_RIGHT);
            box.setStyle("-fx-background-color: gray;");

            popup.getContent().add(box);          
            popup.setX(e.getScreenX());
            popup.setY(e.getScreenY());
            popup.show(stage);
        }       
    }
}