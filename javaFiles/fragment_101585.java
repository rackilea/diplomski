import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        StackPane view = new StackPane();
        view.setPrefSize(200,200);
        view.setOnMouseClicked(event -> view.requestFocus());
        view.setOnKeyPressed(event -> {
            switch (event.getCode().toString()) {
                case "UP":
                    event.consume();
                    System.out.println("UP");
//                        model.tryMove(Richting.OMHOOG);
                    break;
                case "DOWN":
                    event.consume();
                    System.out.println("DOWN");
//                        model.tryMove(Richting.LINKS);
                    break;
                case "LEFT":
                    event.consume();
                    System.out.println("LEFT");
//                        model.tryMove(Richting.LINKS);
                    break;
                case "RIGHT":
                    event.consume();
                    System.out.println("RIGHT");
//                        model.tryMove(Richting.RECHTS);
                    break;
            }
//                model.checkDone();
        });


        Scene scene = new Scene(view);

        stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) { launch(args); }
}