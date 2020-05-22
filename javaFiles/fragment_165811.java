import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.*;
import java.awt.geom.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

@SuppressWarnings("serial")
public class MainGates2 extends JPanel {
    private static final int PREF_W = 700;
    private static final int PREF_H = 600;
    private List<MyGate> gates = new ArrayList<>();

    public MainGates2() {
        // create a few Gates
        MyGate gate1 = new OrGate();
        gate1.setPoint(new Point(200, 300)); // move this guy
        MyGate gate2 = new OrGate();

        // add them to the gates ArrayList
        gates.add(gate1);
        gates.add(gate2);

        // create our mouse listener / adapter and add to JPanel
        MyMouse myMouse = new MyMouse();
        addMouseListener(myMouse);
        addMouseMotionListener(myMouse);        
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        // rendering hints to smooth graphics
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // iterate through collection and draw
        for (MyGate myGate : gates) {
            myGate.draw(g2);
        }

    }

    @Override
    public Dimension getPreferredSize() {
        if (isPreferredSizeSet()) {
            return super.getPreferredSize();
        }
        // give our JPanel some size
        return new Dimension(PREF_W, PREF_H);
    }

    private class MyMouse extends MouseAdapter {
        private MyGate selectedGate = null;
        private Point p0; // initial Gate location
        private Point p1; // first mouse press location

        @Override
        public void mousePressed(MouseEvent e) {
            if (e.getButton() != MouseEvent.BUTTON1) {
                return;
            }
            p1 = e.getPoint();
            for (int i = gates.size() - 1; i >= 0; i--) {
                if (gates.get(i).contains(e.getPoint())) {
                    selectedGate = gates.get(i);
                    p0 = selectedGate.getPoint();
                    return;
                }
            }
            p1 = null;
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            if (selectedGate != null) {
                dragShape(e);

                // de-select the gate
                selectedGate = null;
                p0 = null;
                p1 = null;
            }
        }

        public void mouseDragged(MouseEvent e) {
            if (selectedGate != null) {
                dragShape(e);
            }
        }

        private void dragShape(MouseEvent e) {
            Point p2 = e.getPoint(); // current mouse location
            int x = p0.x + p2.x - p1.x;
            int y = p0.y + p2.y - p1.y;
            Point p = new Point(x, y);
            selectedGate.setPoint(p);
            repaint();
        };
    }

    private static void createAndShowGui() {
        // main JPanel
        MainGates2 mainPanel = new MainGates2();

        JFrame frame = new JFrame("Main Gates2");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGui());
    }
}