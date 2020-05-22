import java.io.IOException;
import battlegame.graphics.Assets;
import battlegame.input.KeyboardController;
import battlegame.world.World;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class Game extends Application{

    public static int screenWidth = 1248;
    public static int screenHeight = 624;

    private Canvas canvas;
    private Stage stage;
    private Scene scene;
    private Group group;
    private GraphicsContext g;
    private final LongProperty lastUpdateTime = new SimpleLongProperty(0);
    private static World currentWorld;
    private static KeyboardController keyController;

    public Game() {
        keyController = new KeyboardController();
    }

    public void begin(String args[]) {
        launch(args);
    }

    public void initialise() throws IOException {
        canvas = new Canvas(screenWidth, screenHeight);
        group = new Group(canvas);
        scene = new Scene(group);
        g = canvas.getGraphicsContext2D();
        Assets.init();
        currentWorld = new World("/testlvl.txt");
        currentWorld.init();

    }

    @Override
    public void start(Stage primaryStage)throws Exception {
        initialise();
        final AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long timestamp) {
                if (lastUpdateTime.get() > 16.6666666667) {
                    tick();
                    render();
                }
                lastUpdateTime.set(timestamp);
            }
        };
        stage = primaryStage;
        stage.getIcons().add(new Image(Game.class.getResourceAsStream("/GameIcon.png")));
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setOnCloseRequest(event -> {
            timer.stop();
        });
        stage.show();
        scene.addEventHandler(KeyEvent.KEY_PRESSED, (key) -> {
              if(key.getCode() == KeyCode.W || key.getCode() == KeyCode.UP || key.getCode() == KeyCode.SPACE) {
                  keyController.up = true;
              }
              if(key.getCode() == KeyCode.A || key.getCode() == KeyCode.LEFT) {
                  keyController.left = true;
              }
              if(key.getCode() == KeyCode.S || key.getCode() == KeyCode.DOWN) {
                  keyController.down = true;
              }
              if(key.getCode() == KeyCode.D || key.getCode() == KeyCode.RIGHT) {
                  keyController.right = true;
              }
              if(key.getCode() == KeyCode.Z || key.getCode() == KeyCode.O || key.getCode() == KeyCode.ENTER) {
                  keyController.select = true;
              }
              if(key.getCode() == KeyCode.P || key.getCode() == KeyCode.X) {
                  keyController.action = true;
              }

        });

        scene.addEventHandler(KeyEvent.KEY_TYPED, (key) -> {
              if(key.getCode() == KeyCode.W || key.getCode() == KeyCode.UP || key.getCode() == KeyCode.SPACE) {
                  keyController.up = true;
              }
        });

        scene.addEventHandler(KeyEvent.KEY_RELEASED, (key) -> {
              if(key.getCode() == KeyCode.W || key.getCode() == KeyCode.UP || key.getCode() == KeyCode.SPACE) {
                  keyController.up = false;
              }
              if(key.getCode() == KeyCode.A || key.getCode() == KeyCode.LEFT) {
                  keyController.left = false;
              }
              if(key.getCode() == KeyCode.S || key.getCode() == KeyCode.DOWN) {
                  keyController.down = false;
              }
              if(key.getCode() == KeyCode.D || key.getCode() == KeyCode.RIGHT) {
                  keyController.right = false;
              }
              if(key.getCode() == KeyCode.Z || key.getCode() == KeyCode.O || key.getCode() == KeyCode.ENTER) {
                  keyController.select = false;
              }
              if(key.getCode() == KeyCode.P || key.getCode() == KeyCode.X) {
                  keyController.action = false;
              }     });



        timer.start();   
    }


    public void tick() {
        keyController.tick();
        currentWorld.tick();

    }

    public void render() {
        g.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        currentWorld.render(g);
    }

    public static void main(String[] args){
        launch();
    }

    public static KeyboardController getKeyController(){
        return keyController;
    }

    public static World getCurrentWorld() {
        return currentWorld;
    }



    }