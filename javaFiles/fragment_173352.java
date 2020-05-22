import javafx.concurrent.Task;
import javafx.scene.shape.Rectangle;

public class Lasser extends Rectangle {

    private volatile boolean isDestroyed = false;

    private double xPos;
    private double yPos;

    public Lasser(double x, double y, long time) {
        super(x, y, 5, 20);
        this.xPos = x;
        this.yPos = y;
        startSelfDestruct(time);
    }

    private void startSelfDestruct(long time) {

        Task<Void> task = new Task<Void>() {
            @Override
            protected Void call() {
                try {
                    Thread.sleep(time);
                } catch (InterruptedException e) {
                }
                return null;
            }
        };

        task.setOnSucceeded(e -> {
            isDestroyed = true;
        });

        new Thread(task).start();
    }

    public void move(double x, double y) {
        this.xPos = x;
        this.yPos = y;
    }

    public boolean isDestroyed() {
        return isDestroyed;
    }

    public double getxPos() {
        return xPos;
    }

    public double getyPos() {
        this.yPos -= 1;
        return yPos;
    }

}