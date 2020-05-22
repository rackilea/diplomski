import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class ConsoleTest {

    /**
     * @param args
     */
    public static void main(String[] args) {
        new TimeoutThread().start();
        new ReaderThread().start();
    }

}

class ReaderThread extends Thread {

    @Override
    public void run() {
        System.out.print("Please enter your name: ");
        try(Scanner in = new Scanner(System.in)) {
            String name = in.nextLine();
            if(name.trim().isEmpty()) {
                name = "TEST"; // default user name
            }
            System.out.println("Name entered = " + name);
        }
    }

}

class TimeoutThread extends Thread {

    @Override
    public void run() {
        try {
            Thread.sleep(TimeUnit.SECONDS.toMillis(5));
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

}