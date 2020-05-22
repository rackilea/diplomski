import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.*;
import java.util.Timer;

import javax.swing.*;

public class StackOverflow {

private final List<JLabel> arrayList = Arrays.asList(new JLabel("This is the first text."), new JLabel("This is the second text."), new JLabel("And this is the third and last text."));
private JFrame frame;
private JButton button;

public static void main(final String[] arguments) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {    
    StackOverflow clazz = new StackOverflow();
    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    clazz.create("Stackoverflow | Question", 350, 200);
    clazz.doLayout();
}

public void create(final String title, final int width, final int height) {
    this.frame = new JFrame(title);
    EventQueue.invokeLater(() -> {
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(width, height);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER));
        frame.getContentPane().setBackground(Color.WHITE);
        frame.setVisible(true);
    });
}

public void doLayout() {
    this.button = new JButton("Answer question");
    EventQueue.invokeLater(() -> {
        button.addActionListener(new ActionListener() {
            int index = 0;
            @Override
            public void actionPerformed(final ActionEvent action) {
                // Important: This is the java.util.Timer and not the javax.swing.Timer class.
                Timer timer = new Timer();
                timer.scheduleAtFixedRate(new TimerTask() {
                    @Override
                    public void run() {
                        if (index + 1 >= arrayList.size()) {
                            timer.cancel();
                        }
                        EventQueue.invokeLater(() -> {
                            frame.getContentPane().add(arrayList.get((index += 1) - 1));
                            frame.getContentPane().validate();
                        });
                    }
                }, 0l, 2000l);
            }
        });
        frame.add(button);
    });
}
}