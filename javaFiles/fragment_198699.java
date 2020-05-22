import java.awt.*;
import java.awt.event.KeyEvent;

public class Simulation extends Thread {
    private volatile boolean loopState = true;

    public void stopLoop() {
        loopState = false;
    }

    public void run() {
        try {
            Robot r = new Robot();

            while (loopState) {
                r.keyPress(KeyEvent.VK_LEFT);
                r.keyRelease(KeyEvent.VK_LEFT);
                System.out.println("Simulation loop: CALLED");
                sleep(50);
            }
        } catch (AWTException | InterruptedException e) {}
    }

    public static void main(String[] args) throws InterruptedException {
        Simulation simulation = new Simulation();
        simulation.start();
        Thread.sleep(1000);
        simulation.stopLoop();
    }
}