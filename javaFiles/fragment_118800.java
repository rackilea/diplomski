import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.AbstractButton;
import javax.swing.DefaultButtonModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class CustomButton {

    public static void main(String[] args) {
        new CustomButton();
    }

    public CustomButton() {
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
                frame.setLayout(new GridBagLayout());
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends AbstractButton {

        public TestPane() {
            setModel(new DefaultButtonModel());
            MouseHandler mh = new MouseHandler();
            addMouseListener(mh);
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(40, 20);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics g2d = (Graphics2D) g.create();
            g2d.setColor(new Color(220, 220, 220));
            g2d.fillRoundRect(0, 0, this.getWidth() - 1, this.getHeight() - 1, 10, 10);
            if (getModel().isRollover()) {
                g2d.setColor(new Color(128, 128, 128));
                g2d.drawRoundRect(0, 0, this.getWidth() - 1, this.getHeight() - 1, 10, 10);
            }
            g2d.dispose();
        }

        public class MouseHandler extends MouseAdapter {

            @Override
            public void mouseEntered(MouseEvent e) {
                getModel().setRollover(true);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                getModel().setRollover(false);
            }

            @Override
            public void mousePressed(MouseEvent e) {
                getModel().setArmed(true);
                getModel().setPressed(true);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                getModel().setPressed(false);
                getModel().setArmed(false);
            }

        }

    }

}