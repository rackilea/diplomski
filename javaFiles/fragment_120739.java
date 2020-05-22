import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Example  implements KeyListener {

    private static long hitTime = -1;

    @Override
    public void keyPressed(KeyEvent arg0) {
        // This will allways return the time when first space bar was clicked
        long start = getHitTime();
        long actualTime = System.currentTimeMillis();
        // In this case get the seconds..
        long diff = (actualTime - start) / 1000;

        System.out.println(String.format("TIme diff: %s", diff));
    }

    @Override
    public void keyReleased(KeyEvent arg0) {
        // TODO Auto-generated method stub
    }

    @Override
    public void keyTyped(KeyEvent arg0) {
        // TODO Auto-generated method stub
    }

    public synchronized static long getHitTime() {

        if (hitTime < 0) {
            hitTime = System.currentTimeMillis();
        }
        return hitTime;
    }
}