import java.awt.FlowLayout;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class Snippet extends JFrame {

    public Snippet(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        JPanel panel = new JPanel(new FlowLayout());
        this.getContentPane().add(panel);

        final PlaybackWAV player = new PlaybackWAV();
        JButton play1 = new JButton("CALLING");
        panel.add(play1);
        JButton play2 = new JButton("RING");
        panel.add(play2);
        JButton play3 = new JButton("BUSY");
        panel.add(play3);
        JButton play4 = new JButton("STOP");
        panel.add(play4);
        this.pack();

        play1.setAction(new AbstractAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
                player.stopSound();
                player.playSound("resources/phone-calling.wav");
            }
        });
        play2.setAction(new AbstractAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
                player.stopSound();
                player.playSound("resources/telephone-ring.wav");
            }
        });
        play3.setAction(new AbstractAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
                player.stopSound();
                player.playSound("resources/phone-busy.wav");
            }
        });
        play4.setAction(new AbstractAction(){

            @Override
            public void actionPerformed(ActionEvent arg0) {
                player.stopSound();
            }
        });
    }

    public static void main(String[] args){
        Snippet snippet = new Snippet();
        snippet.setVisible(true);
    }

}