public class Controller {

    @FXML private VBox root;
    private List<TextField> all = new ArrayList<>();

    public Controller(){}
    @FXML
    public void initialize(){
        EventHandler<ActionEvent> customEvent = e -> {
            if(e.getSource().getClass() == Button.class){
                all.forEach(t -> t.fireEvent(new ActionEvent()));
            }else {
                System.out.println(((TextField) e.getSource()).getText());
            }
        };

        for(int i=0; i < 10; i++){
            TextField tf = new TextField(Integer.toString(i));
            tf.setOnAction(customEvent);
            all.add(tf);
            root.getChildren().add(tf);
        }
        Button btn = new Button();
        btn.setOnAction(customEvent);
        root.getChildren().add(btn);
    }

}