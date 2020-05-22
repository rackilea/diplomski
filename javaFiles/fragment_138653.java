import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class Main {
    public static void main(String[] args) {
        final JFrame frame = new JFrame();
        final JTextField text = new JTextField(20);
        final JSlider slider = new JSlider(0, 100, 0);
        slider.addChangeListener(new ChangeListener(){
            @Override
            public void stateChanged(ChangeEvent e) {
                text.setText(String.valueOf(slider.getValue()));
            }
        });
        text.addKeyListener(new KeyAdapter(){
            @Override
            public void keyReleased(KeyEvent ke) {
                String typed = text.getText();
                slider.setValue(0);
                if(!typed.matches("\\d+") || typed.length() > 3) {
                    return;
                }
                int value = Integer.parseInt(typed);
                slider.setValue(value);
            }
        });
        frame.setLayout(new BorderLayout());
        frame.add(text, BorderLayout.NORTH);
        frame.add(slider, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.pack();
    }
}