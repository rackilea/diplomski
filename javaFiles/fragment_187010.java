import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class BoardView extends Application {

    // the dimensions of our background Image
    private final int BORDER_WIDTH = 695;
    private final int BORDER_HEIGHT = 720;

    @Override
    public void start(Stage stage) throws Exception {

        // Load your Image
        ImageView backgroundImageView = new ImageView(
                new Image("https://cdn.pixabay.com/photo/2013/07/13/10/24/board-157165_960_720.png"));
        // Initialize the grid
        GridPane boardGrid = initBoard();
        // Set the dimensions of the grid
        boardGrid.setPrefSize(BORDER_WIDTH, BORDER_HEIGHT);

        // Use a StackPane to display the Image and the Grid
        StackPane mainPane = new StackPane();
        mainPane.getChildren().addAll(backgroundImageView, boardGrid);

        stage.setScene(new Scene(mainPane));
        stage.setResizable(false);
        stage.show();

    }

    private GridPane initBoard() {
        GridPane boardGrid = new GridPane();

        int tileNum = 8;
        double tileWidth = BORDER_WIDTH / tileNum;
        double tileHeight = BORDER_HEIGHT / tileNum;

        for (int i = 0; i < tileNum; i++) {
            for (int j = 0; j < tileNum; j++) {
                Tile tile = new Tile(i, j);
                // Set each 'Tile' the width and height
                tile.setPrefSize(tileWidth, tileHeight);
                // Add node on j column and i row
                boardGrid.add(tile, j, i);
            }
        }
        // Return the GridPane
        return boardGrid;
    }

    class Tile extends Pane {
        private int positionX;
        private int positionY;

        public Tile(int x, int y) {
            positionX = x;
            positionY = y;
            setOnMouseClicked(e -> {
                System.out.println(positionX + " " + positionY);
            });
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}