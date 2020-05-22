import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
* @see https://stackoverflow.com/q/11376272/230513
*/
public class Disegno extends JFrame {

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new Disegno();
            }
        });
    }

    Disegno() {
        this.setSize(500, 500);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        MyPanel aba = new MyPanel();
        this.add(aba);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    class MyPanel extends JPanel {

        private JPanel up, down;
        private RectArea rect;

        MyPanel() {
            super(new BorderLayout());

            up = new JPanel();
            up.setBackground(Color.red);
            this.add(up, BorderLayout.NORTH);

            rect = new RectArea();
            this.add(rect, BorderLayout.CENTER);

            down = new JPanel();
            down.setBackground(Color.green);
            this.add(down, BorderLayout.SOUTH);
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(320, 240);
        }
    }

    class RectArea extends JPanel {

        private Rectangle blue = new Rectangle(0, 0, 100, 100);
        private Rectangle yellow = new Rectangle(0, 0, 100, 100);

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            System.out.println(this.getWidth() + " x " + this.getHeight());
            g.setColor(Color.blue);
            g.fillRect(blue.x, blue.y, blue.width, blue.height);

            g.setColor(Color.yellow);
            int dx = getWidth() - yellow.width;
            int dy = getHeight() - yellow.height;
            g.fillRect(dx, dy, yellow.width, yellow.height);
        }
    }
}