import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.FontMetrics;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Test {

    public static void main(String[] args) {
        new Test();
    }

    public Test() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new JPanelEx());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class JPanelEx extends JPanel {

        private int numElements = 10;

        public JPanelEx() {
            super(new FlowLayout());
        }

        @Override
        public Dimension getPreferredSize() {

            FontMetrics fm = getFontMetrics(getFont());
            int width = 0;
            int height = fm.getHeight() * numElements;
            for (int index = 0; index < numElements; index++) {
                width = Math.max(width, fm.stringWidth("Hello" + index));
            }

            return new Dimension(width, height);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            int x = 0;
            int y = 0;
            FontMetrics fm = g.getFontMetrics();
            for (int index = 0; index < numElements; index++) {
                g.drawString("Hello" + index, x, y + fm.getAscent());
                y += fm.getHeight();
            }
        }
    }

}