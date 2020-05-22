import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.lang.reflect.Field;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Main {

    public static void main(String[] args) throws Exception {
        final JFrame frame = new JFrame("frame");
        final JButton button = new JButton("button");
        removeMulticlickThreshold(button);

        button.addActionListener(new ActionListener() {

            public void actionPerformed(final ActionEvent e) {
                System.out.println("Button Pressed!");
            }
        });

        frame.add(button);
        frame.setSize(200, 200);
        frame.setVisible(true);
        frame.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(final WindowEvent e) {
                System.exit(0);
            }
        });
    }

    private static void removeMulticlickThreshold(final JButton button) throws Exception {
        final Field multiClickThreshhold = AbstractButton.class.getDeclaredField("multiClickThreshhold");
        multiClickThreshhold.setAccessible(true);
        multiClickThreshhold.set(button, Long.MIN_VALUE);
    }

}