import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.swing.*;

@SuppressWarnings("serial")
public class MainPaintPanel extends JPanel {
    private PaintPanel paintPanel = new PaintPanel();

    public MainPaintPanel() {
        MyMouse myMouse = new MyMouse();
        paintPanel.addMouseListener(myMouse);
        paintPanel.addMouseMotionListener(myMouse);
        JPanel btnPanel = new JPanel(new GridLayout(0, 1, 3, 3));
        addColorButton(btnPanel, Color.RED, "Red");
        addColorButton(btnPanel, Color.YELLOW, "Yellow");
        addColorButton(btnPanel, Color.BLUE, "Blue");
        addColorButton(btnPanel, Color.GREEN, "Green");        

        setLayout(new BorderLayout());
        add(paintPanel, BorderLayout.CENTER);
        add(btnPanel, BorderLayout.LINE_START);
    }

    class MyMouse extends MouseAdapter {
        Point p1 = null;

        private void moveOval(MouseEvent e) {
            if (p1 == null) {
                return;
            }
            Point p2 = e.getPoint();
            paintPanel.addLine(p1, p2);
        }

        @Override
        public void mousePressed(MouseEvent e) {
            p1 = e.getPoint();
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            moveOval(e);
            p1 = e.getPoint();
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            moveOval(e);
            p1 = null;
        }
    }

    private void addColorButton(JPanel btnPanel, Color color, String name) {
        JButton button = new JButton(new ButtonAction(name, color));
        button.setBackground(color);
        btnPanel.add(button);
    }

    class ButtonAction extends AbstractAction {        
        private Color color;

        public ButtonAction(String name, Color color) {
            super(name);
            this.color = color;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            paintPanel.setOvalColor(color);
        }
    }


    private static void createAndShowGui() {
        MainPaintPanel mainPanel = new MainPaintPanel();

        JFrame frame = new JFrame("Painting GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGui());
    }
}