import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class TestKeyboard {

    public static void main(String[] args) {
        new TestKeyboard();
    }

    public TestKeyboard() {
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
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        private List<JButton> buttons;

        public TestPane() {
            setFocusable(true);
            setLayout(new GridLayout(0, 4));
            buttons = new ArrayList<>(26);
            for (int index = 0; index < 26; index++) {
                JButton btn = createButton(index);
                buttons.add(btn);
                add(btn);
            }

            addKeyListener(new KeyAdapter() {

                @Override
                public void keyPressed(KeyEvent e) {
                    if (e.getKeyCode() == KeyEvent.VK_SHIFT) {
                        for (JButton btn : buttons) {
                            String text = btn.getText().toUpperCase();
                            btn.setText(text);
                        }
                        revalidate();
                        repaint();
                    }
                }

                @Override
                public void keyReleased(KeyEvent e) {
                    if (e.getKeyCode() == KeyEvent.VK_SHIFT) {
                        for (JButton btn : buttons) {
                            String text = btn.getText().toLowerCase();
                            btn.setText(text);
                        }
                        revalidate();
                        repaint();
                    }
                }               
            });
        }

        protected JButton createButton(int index) {
            JButton btn = new JButton(Character.toString((char) ('a' + index)));
            btn.setMargin(new Insets(4, 4, 4, 4));
            btn.setFocusable(false);
            btn.setFocusPainted(false);
            return btn;
        }

    }

}