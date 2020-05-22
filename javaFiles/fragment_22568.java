import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

public class LostMouseEvent {

    private JPanel panel1;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                new LostMouseEvent();
            }
        });
    }

    public LostMouseEvent() {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                JFrame frame = new JFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                panel1 = new JPanel() {
                    private static final long serialVersionUID = 1L;

                    @Override
                    public Dimension getPreferredSize() {
                        return new Dimension(600, 400);
                    }
                };
                JPanel panel2 = new JPanel() {
                    private static final long serialVersionUID = 1L;

                    @Override
                    public Dimension getPreferredSize() {
                        return new Dimension(500, 300);
                    }
                };
                JScrollPane pane = new JScrollPane(panel2);
                panel1.setBorder(BorderFactory.createLineBorder(Color.blue));
                panel2.setBorder(BorderFactory.createLineBorder(Color.green));
                panel1.setLayout(new CircleLayout());
                panel1.add(pane);
                frame.add(panel1);
                MouseListener rml = new RealMouseListener();
                panel1.addMouseListener(rml);
                MouseListener fml = new FakeMouseListener();
                pane.addMouseListener(fml);
                frame.pack();
                frame.setVisible(true);

            }
        });
    }

    private class RealMouseListener extends MouseAdapter {

        @Override
        public void mousePressed(MouseEvent me) {
            System.out.println(me);
            Point point = me.getPoint();
            System.out.println(me.getX());
            System.out.println(me.getXOnScreen());
            System.out.println(me.getY());
            System.out.println(me.getYOnScreen());
        }
    }

    private class FakeMouseListener extends MouseAdapter {

        @Override
        public void mousePressed(MouseEvent me) {
            JScrollPane pane = (JScrollPane) me.getSource();
            MouseEvent newMe = SwingUtilities.convertMouseEvent(pane.getViewport(), me, panel1);
            System.out.println(newMe.getX());
            System.out.println(newMe.getXOnScreen());
            System.out.println(newMe.getY());
            System.out.println(newMe.getYOnScreen());
            panel1.dispatchEvent(me);
        }
    }
}