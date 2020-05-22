import java.awt.Color;
import java.awt.Graphics;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class TestGlassPane {

    private static final int COUNTDOWN = 10;

    private static final String CLICK_ME = "Click me";

    private static final Color GRAY = new Color(192, 192, 192, 128);

    private JFrame frame;

    private JButton button;

    private Timer timer;

    private int countdown;

    private KeyEventDispatcher blockingDispatcher;

    private static class GrayPanel extends JComponent {
        @Override
        protected void paintComponent(Graphics g) {
            g.setColor(GRAY);
            g.fillRect(0, 0, getWidth(), getHeight());
        }
    }

    public TestGlassPane() {
        blockingDispatcher = new KeyEventDispatcher() {

            @Override
            public boolean dispatchKeyEvent(KeyEvent e) {
                return true;
            }
        };

    }

    protected void initUI() {
        frame = new JFrame(TestGlassPane.class.getSimpleName());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        button = new JButton(CLICK_ME);
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                blockUserInput();
            }
        });
        GrayPanel glassPane = new GrayPanel();
        glassPane.addMouseListener(new MouseAdapter() {
        });
        frame.setGlassPane(glassPane);
        frame.add(button);
        frame.setSize(200, 200);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    protected void blockUserInput() {
        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(blockingDispatcher);
        frame.getGlassPane().setVisible(true);
        countdown = COUNTDOWN;
        timer = new Timer(1000, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                countdown--;
                if (countdown == 0) {
                    timer.stop();
                    frame.getGlassPane().setVisible(false);
                    button.setText(CLICK_ME);
                    KeyboardFocusManager.getCurrentKeyboardFocusManager().removeKeyEventDispatcher(blockingDispatcher);
                } else {
                    button.setText("We will be back in " + countdown + " seconds");
                }
            }
        });
        timer.start();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TestGlassPane().initUI();
            }
        });
    }

}