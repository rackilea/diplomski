import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Dynamic_Bg_Color extends JPanel {

    private static final long serialVersionUID = 1L;

    public Dynamic_Bg_Color() {
        setBackground(Color.cyan);
        addMouseListener(new Handler());
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(500, 500);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        System.out.println("Click");

        g.setColor(Color.blue);
        g.fillRect(20, 20, getWidth() - 40, 100);

        g.setColor(Color.green);
        g.fillRect(20, 140, getWidth() - 40, 100);

        g.setColor(Color.orange);
        g.fillRect(20, 260, getWidth() - 40, 100);
    }

    public class Handler extends MouseAdapter {

        @Override
        public void mousePressed(MouseEvent e) {

            int x = e.getX();
            int y = e.getY();

            System.out.println(x + "x" + y);

            if (x >= 20 && x <= getWidth() - 40 && y >= 20 && y <= 120) {
                setBackground(Color.blue);
            }
            if (x >= 20 && x <= getWidth() - 40 && y >= 140 && y <= 240) {
                setBackground(Color.green);
            }
            if (x >= 20 && x <= getWidth() - 40 && y >= 260 && y <= 360) {
                setBackground(Color.orange);
            }
            repaint();
        }

    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                Dynamic_Bg_Color d = new Dynamic_Bg_Color();

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(d);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

}