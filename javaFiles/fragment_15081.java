public class ExampleFX extends Application{

    private int value = 0 ;

    public static void main(String[] args){
        launch(args);
    }

    public void start(Stage primaryStage) {

        Button button = new Button();

        button.setOnAction( e -> value +=1);

    }
}