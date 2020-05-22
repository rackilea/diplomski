import java.awt.Canvas;

public class Game extends Canvas implements Runnable {

    private static final long serialVersionUID = 7580815534084638412L;

    public static final int WIDTH = 640, HEIGHT = WIDTH / 12 * 9;

    public Game() {
       // removed line new window()
    }

    public synchronized void start() {

    }

    public void run() {

    }

    public static void main(String args[]) {
       // removed line new game()
       new Window(WIDTH, HEIGHT, "Lets Build a Game!"); // added this line here
    }
}