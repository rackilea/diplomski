import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

// Testing the SoundEffect enum in a Swing application
@SuppressWarnings("serial")
public class SoundEffectDemo extends JFrame {


    // Constructor
    public SoundEffectDemo() {
        // Pre-load all the sound files


        // Set up UI components
        Container cp = this.getContentPane();
        cp.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

        JButton btnSound1 = new JButton("CALLING");
        btnSound1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SoundEffect.CALLING.play(); 
            }
        });
        cp.add(btnSound1);

        JButton btnSound2 = new JButton("RING");
        btnSound2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SoundEffect.RING.play();
            }
        });
        cp.add(btnSound2);

        JButton btnSound3 = new JButton("BUSY");
        btnSound3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                SoundEffect.BUSY.play();
            }
        });
        cp.add(btnSound3);

        JButton btnSound4 = new JButton("Stop Sound ");
        btnSound4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for(SoundEffect value : SoundEffect.values()){
                    if(value.isActive()){
                        value.stop();
                    }
                }

            }
        });
        cp.add(btnSound4);


        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Test SoundEffct");
        this.pack();
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new SoundEffectDemo();
    }
}