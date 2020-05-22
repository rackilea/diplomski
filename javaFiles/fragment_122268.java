import java.util.Random;

public class YourClass {
    Random rnd = new Random();
    // insert variable declarations here...

    public void yourMethod() {
        if (centerX > width + 200) {
            isTravelling = false;
            centerX = -200;
            centerY = rnd.nextInt(499) + 101;
        }
    }
}