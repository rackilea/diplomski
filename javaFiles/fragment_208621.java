import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.LineBorder;

public class KeyBindings {

    public static void main(String[] args) {
        new KeyBindings();
    }

    public KeyBindings() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        public TestPane() {

            setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 1;
            gbc.gridy = 0;

            add(new KeyPane(KeyEvent.VK_UP, 0), gbc);

            gbc.gridy = 2;
            add(new KeyPane(KeyEvent.VK_DOWN, 0), gbc);

            gbc.gridx = 0;
            gbc.gridy = 1;
            add(new KeyPane(KeyEvent.VK_LEFT, 0), gbc);

            gbc.gridx = 2;
            add(new KeyPane(KeyEvent.VK_RIGHT, 0), gbc);

        }
    }

    public class KeyPane extends JPanel {

        public KeyPane(int keyCode, int modifier) {

            setBorder(new LineBorder(Color.DARK_GRAY));

            InputMap im = getInputMap(WHEN_IN_FOCUSED_WINDOW);
            ActionMap am = getActionMap();

            im.put(KeyStroke.getKeyStroke(keyCode, modifier, false), "keyPressed");
            im.put(KeyStroke.getKeyStroke(keyCode, modifier, true), "keyReleased");

            am.put("keyPressed", new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setBackground(Color.RED);
                }
            });

            am.put("keyReleased", new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setBackground(UIManager.getColor("Panel.background"));
                }
            });

        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(20, 20);
        }
    }

}