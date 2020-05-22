import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class TicTacToe extends Application {

    private static int ROWS = 6, COLS = 3;
    private static String[] BUTTONS_TEXT = {"X", "O"};

    //always use publicly available resources when posting mre
    private static final String[] imageLink = {
            "http://iconsetc.com/icons-watermarks/simple-black/alphanum/alphanum_lowercase-letter-x/alphanum_lowercase-letter-x_simple-black_64x64.png",
            "http://iconsetc.com/icons-watermarks/simple-black/alphanum/alphanum_lowercase-letter-o/alphanum_lowercase-letter-o_simple-black_64x64.png",
    };

    //construct images once
    private static Image[] images=  {new Image(imageLink[0]), new Image(imageLink[1])};

    @Override
    public void start(Stage primaryStage) throws Exception {

        GridPane gBox = new GridPane();

        for (int col = 0; col < COLS ; col++){
            for (int row = 0; row < ROWS ; row++){
                Button button = new Button();
                button.setOnAction(new ButtonClickHandler(BUTTONS_TEXT[0]));
                button.setGraphic(new ImageView(images[0]));
                gBox.add(button, col, row);
            }
        }

        gBox.setHgap(10);  gBox.setVgap(10);
        gBox.setPadding(new Insets(10));

        Scene scene = new Scene(gBox);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Tic Tac Toe");
        primaryStage.show();
    }

    class ButtonClickHandler implements EventHandler<ActionEvent>{

        private String buttonState; //keeps the current state of the button

        ButtonClickHandler(String buttonState){
            this.buttonState = buttonState;
        }

        @Override
        public void handle(ActionEvent event){

            Button btn = (Button) event.getSource();
            if(buttonState.equals(BUTTONS_TEXT[0])){
                btn.setGraphic(new ImageView(imageLink[1]));
                buttonState = BUTTONS_TEXT[1];
            }else{
                btn.setGraphic(new ImageView(imageLink[0]));
                buttonState = BUTTONS_TEXT[0];
            }
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}