import com.sun.jdi.ArrayReference;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.util.Duration;

class PositionCounter
{

    public int position;

    public void setPosition(int newPos)
    {
        position = newPos;
    }
}

public class JavaFXTestingGround extends Application
{

//    public void drawRectangle(int x1, int y1, int x2, int y2, Stage primStage, GraphicsContext gc){
//        drawLine(x1, y2, x2, y2 , primStage, gc);
//        drawLine(x1, y1, x2, y2, primStage, gc);
//        drawLine(x1, y1, x1 , y2, primStage, gc);
//        drawLine(x2, y1, x2 , y2, primStage, gc);
//        drawLine(x1, y1, x2, y1 , primStage, gc);
//
//    }
//
    public void fillPosition(ArrayList<Integer[]> points, GraphicsContext gc, int positionInArray)
    {
        gc.fillRect(points.get(positionInArray)[0], points.get(positionInArray)[1], squareWidth / 2, squareWidth / 2);
        //System.out.println("(" + points.get(positionInArray)[0] + ", " + points.get(positionInArray)[1]);
    }

    public void drawLine(int x1, int y1, int x2, int y2, Stage primStage, GraphicsContext gc)
    {

        ArrayList<Integer[]> points = calculateLine(x1, y1, x2, y2, gc);
        PositionCounter position = new PositionCounter();

        int dy = Math.abs(y2 - y1);
        int dx = Math.abs(x2 - x1);
        int m = (dy >= dx) ? dy : dx;

        AtomicInteger counter = new AtomicInteger();
        Timeline animationTimeline = new Timeline(new KeyFrame(Duration.millis(20), (ActionEvent t) -> {
            position.setPosition(counter.getAndIncrement());
            fillPosition(points, gc, position.position);
        }));
        animationTimeline.setCycleCount(points.size());
        animationTimeline.play();

    }

    @Override
    public void start(Stage primaryStage) throws Exception
    {

        //STUFF
        Group root = new Group();
        Scene scene = new Scene(root, 400, 400);
        scene.setFill(Color.GOLD);

        Canvas canvas = new Canvas(400, 400);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        root.getChildren().add(canvas);
        //////////

        gc.fillRect(0, 200, 400, 1);
        gc.fillRect(0, 100, 400, 1);
        gc.fillRect(0, 300, 400, 1);
        gc.fillRect(200, 0, 1, 400);
        gc.fillRect(100, 0, 1, 400);
        gc.fillRect(300, 0, 1, 400);

        // drawRectangle(50, 50, 350, 250, primaryStage, gc);
        //drawLine(50, 250, 350, 250 , primaryStage, gc);
        //drawLine(50, 50, 350, 250, primaryStage, gc);
        //drawLine(50, 50, 50 , 250, primaryStage, gc);
        //drawLine(350, 50, 350 , 250, primaryStage, gc);
        drawLine(50, 50, 350, 50, primaryStage, gc);

        //////////
        primaryStage.setScene(scene);
        primaryStage.show();
        /////////
    }

    int squareWidth = 2;

    public ArrayList<Integer[]> calculateLine(int x1, int y1, int x2, int y2, GraphicsContext gc)
    {

        ArrayList<Integer[]> points = new ArrayList<Integer[]>();

        int dy = Math.abs(y2 - y1);
        int dx = Math.abs(x2 - x1);

        int sx = (x1 < x2) ? 1 : -1;
        int sy = (y1 < y2) ? 1 : -1;

        int err = dx - dy;
        int x = x1;
        int y = y1;
        int e2 = 0;

        Integer[] pos = new Integer[2];
        pos[0] = x;
        pos[1] = y;
        points.add(pos);

        int m = (dy >= dx) ? dy : dx;

        for (int i = 0; i <= m; i++) {

            e2 = 2 * err;
            if (e2 > -dy) {
                err = err - dy;
                x = x + sx;
                Integer[] position = new Integer[2];
                position[0] = x;
                position[1] = y;
                points.add(position);
            }

            if (e2 < dx) {
                err = err + dx;
                y = y + sy;
                Integer[] position = new Integer[2];
                position[0] = x;
                position[1] = y;
                points.add(position);
            }

        }

        return points;
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}