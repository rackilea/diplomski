import java.util.Set;
import java.util.TreeSet;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import static javafx.scene.input.KeyCode.DOWN;
import static javafx.scene.input.KeyCode.SHIFT;
import static javafx.scene.input.KeyCode.UP;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Test extends Application {

    enum Direction {
        UP, DOWN, LEFT, RIGHT;
    }

    private static final double W = 600, H = 400;

    private Image playerOneImage;
    private Node playerOneNode;

    private Image playerTwoImage;
    private Node playerTwoNode;

    private Set<Direction> playerOneDirection = new TreeSet<>();
    private Set<Direction> playerTwoDirection = new TreeSet<>();

    boolean running;

    @Override
    public void start(Stage stage) throws Exception {
        playerOneImage = makePlayerOne();
        playerOneNode = new ImageView(playerOneImage);

        playerTwoImage = makePlayerTwo();
        playerTwoNode = new ImageView(playerTwoImage);

        Group dungeon = new Group(playerOneNode, playerTwoNode);

        movePlayerTo(playerOneNode, 0, 0);
        movePlayerTo(playerTwoNode, W - 12.5, H - 12.5);

        Scene scene = new Scene(dungeon, W, H, Color.FORESTGREEN);

        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                switch (event.getCode()) {
                    case UP:
                        playerOneDirection.add(Direction.UP);
                        break;
                    case DOWN:
                        playerOneDirection.add(Direction.DOWN);
                        break;
                    case LEFT:
                        playerOneDirection.add(Direction.LEFT);
                        break;
                    case RIGHT:
                        playerOneDirection.add(Direction.RIGHT);
                        break;
                    case W:
                        playerTwoDirection.add(Direction.UP);
                        break;
                    case S:
                        playerTwoDirection.add(Direction.DOWN);
                        break;
                    case A:
                        playerTwoDirection.add(Direction.LEFT);
                        break;
                    case D:
                        playerTwoDirection.add(Direction.RIGHT);
                        break;
                }
            }
        });

        scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                switch (event.getCode()) {
                    case UP:
                        playerOneDirection.remove(Direction.UP);
                        break;
                    case DOWN:
                        playerOneDirection.remove(Direction.DOWN);
                        break;
                    case LEFT:
                        playerOneDirection.remove(Direction.LEFT);
                        break;
                    case RIGHT:
                        playerOneDirection.remove(Direction.RIGHT);
                        break;
                    case W:
                        playerTwoDirection.remove(Direction.UP);
                        break;
                    case S:
                        playerTwoDirection.remove(Direction.DOWN);
                        break;
                    case A:
                        playerTwoDirection.remove(Direction.LEFT);
                        break;
                    case D:
                        playerTwoDirection.remove(Direction.RIGHT);
                        break;
                }
            }
        });

        stage.setScene(scene);
        stage.show();

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                movePlayer(playerOneNode, playerOneDirection);
                movePlayer(playerTwoNode, playerTwoDirection);
            }
        };
        timer.start();
    }

    private void movePlayer(Node playerNode, Set<Direction> direction) {
        int dx = 0;
        int dy = 0;
        if (direction.contains(Direction.UP)) {
            dy -= 1;
        }
        if (direction.contains(Direction.DOWN)) {
            dy += 1;
        }
        if (direction.contains(Direction.RIGHT)) {
            dx += 1;
        }
        if (direction.contains(Direction.LEFT)) {
            dx -= 1;
        }
        if (running) {
            dx *= 3;
            dy *= 3;
        }
        if (dx == 0 && dy == 0) {
            return;
        }

        final double cx = playerNode.getBoundsInLocal().getWidth() / 2;
        final double cy = playerNode.getBoundsInLocal().getHeight() / 2;

        double x = cx + playerNode.getLayoutX() + dx;
        double y = cy + playerNode.getLayoutY() + dy;

        movePlayerTo(playerNode, x, y);
    }

    private void movePlayerTo(Node playerNode, double x, double y) {
        final double cx = playerNode.getBoundsInLocal().getWidth() / 2;
        final double cy = playerNode.getBoundsInLocal().getHeight() / 2;

        if (x - cx >= 0
                        && x + cx <= W
                        && y - cy >= 0
                        && y + cy <= H) {
            playerNode.relocate(x - cx, y - cy);
        }
    }

    protected Image makePlayerOne() {
        return makePlayer(Color.RED);
    }

    protected Image makePlayerTwo() {
        return makePlayer(Color.BLUE);
    }

    protected Image makePlayer(Color color) {
        WritableImage image = new WritableImage(25, 25);
        PixelWriter writer = image.getPixelWriter();
        for (int y = 0; y < 25; y++) {
            for (int x = 0; x < 25; x++) {
                writer.setColor(x, y, color);
            }
        }
        return image;
    }

    public static void main(String[] args) {
        launch(args);
    }
}