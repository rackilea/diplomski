import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class BadFrame {

    public static void main(String[] args) {
        new BadFrame();
    }

    public BadFrame() {
        Application app = new Application();
        app.setSize(new Dimension(640, 480));
        app.setTitle("This is a test");
        app.setLayout(new BorderLayout());
        app.add(new MyCanvas());
        app.setVisible(true);
    }

    class MyWindowAdapter extends WindowAdapter {

        public void windowClosing(WindowEvent we) {
            System.exit(0);
        }
    }

    public class MyCanvas extends Component {

        @Override
        public void paint(Graphics g) {
            super.paint(g);
            System.out.println("Hey hey !");
            g.drawString("Test", 10, 10);
        }

    }

    class Application extends Frame {

        public Application() {
            addWindowListener(new MyWindowAdapter());
        }

    }
}