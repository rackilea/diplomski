package play;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Other {

    private AudioPlay au;
    private JButton btnStop;

    public Other(AudioPlay aupl, JFrame f){
        this.au = aupl;
        btnStop = new JButton("Stop");
        f.add(btnStop);
        btnStop.addActionListener(new  ActionListener() {
           public void actionPerformed(ActionEvent e) {
                au.stopSound();                       
           }


        });
    }

}