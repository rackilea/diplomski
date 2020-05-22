import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class TicTacToe extends Application {

    private static String[] BUTTONS_TEXT = {"X", "O"};
    private static int ROWS = 6, COLS = 3;

    @Override
    public void start(Stage primaryStage) throws Exception {

        GridPane gBox = new GridPane();
        ButtonClickHandler mbh = new ButtonClickHandler();

        for (int col = 0; col < COLS ; col++){
            for (int row = 0; row < ROWS ; row++){
                Button button = new Button(BUTTONS_TEXT[0]);
                button.setOnAction(mbh);
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
        @Override
        public void handle(ActionEvent event){
            Button btn = (Button) event.getSource();
            btn.setText(btn.getText().equals(BUTTONS_TEXT[0]) ? BUTTONS_TEXT[1] : BUTTONS_TEXT[0]);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}