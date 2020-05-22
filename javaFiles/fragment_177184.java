import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Random;

public class Horse {

    public static final int RADIUS = 15;
    public static final int MARGIN = 15;
    public static final int DIAMETER = RADIUS + RADIUS;
    public static final int POSITION = DIAMETER + MARGIN;

    private static Point currentPosition;

    static {
        int x = MARGIN + RADIUS;
        int y = MARGIN + RADIUS;
        currentPosition = new Point(x, y);
    }

    private static Random random = new Random();


    /** Distance in pixels */
    private double distance;

    /** Velocity in pixels per second */
    private int velocity;

    private Color color;

    /** Initial position in pixels */
    private Point initialPosition;

    private String name;

    public Horse(Color color, String name) {
        setInitialPosition();
        this.color = color;
        this.name = name;
        init();
    }

    private void setInitialPosition() {
        this.initialPosition = 
                new Point(currentPosition.x, currentPosition.y);
        currentPosition.y += POSITION;
    }

    public void init() {
        this.distance = 0.0D;
    }

    public void setVelocity() {
        this.velocity = random.nextInt(5) + 6;
    }

    public double getDistance() {
        return distance;
    }

    public String getName() {
        return name;
    }

    public void moveHorse(int milliseconds) {
        double pixels = 0.001D * velocity * milliseconds;
        this.distance += pixels;
    }

    public void draw(Graphics g) {
        g.setColor(color);
        g.fillOval(initialPosition.x + (int) Math.round(distance) - RADIUS,
                initialPosition.y - RADIUS, DIAMETER, DIAMETER);
    }

}