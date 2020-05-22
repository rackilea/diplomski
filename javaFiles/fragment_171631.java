import java.awt.Toolkit;
import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class FxMain extends Application {

    private static final int COLS = 5, ROWS = 5;
    private int clickCounter = 0;
    private GridPane grid;
    private Button first, second;

    @Override
    public void start(Stage primaryStage){

        VBox root = new VBox(10);
        root.setPadding(new Insets(10));
        root.getChildren().addAll(makeGrid(), 
                new Text("Click 2 buttons to find the \n diagonally between them"));
        primaryStage.setScene(new Scene(root));
        primaryStage.sizeToScene();
        primaryStage.show();
    }

    private Pane makeGrid() {

        grid = new GridPane();
        for(int rowIndex = 0; rowIndex < ROWS ; rowIndex++) {
            //an array to hold buttons of one row
            Node[] nodes = new Node[COLS];
            for(int colIndex = 0; colIndex < COLS ; colIndex++) {
                Button node= new Button(rowIndex+""+colIndex);
                node.setOnAction(e->buttonCliked(node)); //add action listener
                nodes[colIndex]= node;
            }
            grid.addRow(rowIndex, nodes);
        }
        return grid;
    }

    private void buttonCliked(Button button) {

        if(clickCounter == 0){
            first = button;
        }else{
            second = button;
            markNode(findMidDiagonalButton());
        }

        System.out.println(clickCounter + " " + button.getText()    );
        clickCounter=  ++clickCounter %2 ;  // changes values between 0 1
    }

    //change node background for a short while, and then reset it
    private void markNode(Node node) {

        if(node == null) return;
        String style = node.getStyle();
        node.setStyle("-fx-background-color: cornflowerblue;");
        PauseTransition pause = new PauseTransition(Duration.seconds(1));
        pause.play();
        pause.setOnFinished(e-> node.setStyle(style));
    }

    private Node findMidDiagonalButton() {

        int rowDelta = GridPane.getRowIndex(first) - GridPane.getRowIndex(second);
        int colDelta = GridPane.getColumnIndex(first) - GridPane.getColumnIndex(second);

        if( Math.abs(rowDelta) != 2 ||  Math.abs(colDelta) != 2 ){
            Toolkit.getDefaultToolkit().beep();
            return null;
        }

        int rowsSum = GridPane.getRowIndex(first) + GridPane.getRowIndex(second);
        int colsSum = GridPane.getColumnIndex(first) + GridPane.getColumnIndex(second);

        return  getNodeByRowCol(Math.abs(rowsSum / 2), Math.abs(colsSum / 2) );
    }

    public Node getNodeByRowCol (int row, int col) {

        for (Node node : grid.getChildren()) {
            if(GridPane.getRowIndex(node) == row && GridPane.getColumnIndex(node) == col)
                return node;
        }

        return null;
    }

    public static void main(final String[] args) {
        launch(args);
    }
}