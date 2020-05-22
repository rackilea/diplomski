import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.Timer;

public class Example {

    private final int BUTTON_WIDTH = 100;
    private final int BUTTON_HEIGHT = 20;

    public Example() {
        JFrame frame = new JFrame();
        frame.setLayout(null);

        Timer timer = new Timer(100, new ActionListener() {
            Random random = new Random();

            @Override
            public void actionPerformed(ActionEvent arg0) {
                JButton button = new JButton("Button");
                button.setBounds(random.nextInt(frame.getContentPane().getWidth() - BUTTON_WIDTH),
                        random.nextInt(frame.getContentPane().getHeight() - BUTTON_HEIGHT), BUTTON_WIDTH,
                        BUTTON_HEIGHT);
                for (int tries = 0; tries < 50; tries++) {
                    if (intersectsComponent(button, frame.getContentPane().getComponents())) {
                        button.setBounds(random.nextInt(frame.getContentPane().getWidth() - BUTTON_WIDTH),
                                random.nextInt(frame.getContentPane().getHeight() - BUTTON_HEIGHT), BUTTON_WIDTH,
                                BUTTON_HEIGHT);
                    } else {
                        frame.add(button);
                        break;
                    }
                }
                frame.revalidate();
                frame.repaint();
            }
        });
        timer.start();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setVisible(true);
    }

    public boolean intersectsComponent(Component component, Component[] components) {
        for (Component c : components) {
            if (c.getBounds().intersects(component.getBounds())) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Example();
            }
        });
    }
}