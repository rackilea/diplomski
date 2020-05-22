import acm.program.*;
import acm.util.RandomGenerator;
import acm.graphics.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TestRect extends GraphicsProgram {
    private static RandomGenerator rand = new RandomGenerator();

    public void run() {
        final GRect rect = new GRect(10, 10, 100, 100);
        rect.setFilled(true);
        rect.setColor(Color.RED);
        add(rect);

        rect.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                rect.setColor(rand.nextColor());
            }
        });
    }
}