import java.awt.event.*;
import javax.swing.*;
import javax.sound.sampled.*;
import java.net.URL;

class ClipControl {

    public static void main(String[] args) throws Exception {
        URL url = new URL("http://pscode.org/media/leftright.wav");
        AudioInputStream ais = AudioSystem.getAudioInputStream(url);
        final Clip clip = AudioSystem.getClip();
        clip.open( ais );
        Runnable r = new Runnable() {
            public void run() {
                final JToggleButton startStop = new JToggleButton("Stop");
                startStop.addActionListener( new ActionListener() {
                    public void actionPerformed(ActionEvent ae) {
                        if (startStop.isSelected()) {
                            clip.stop();
                            startStop.setText("Start");
                        } else {
                            clip.loop(-1);
                            clip.start();
                            startStop.setText("Stop");
                        }
                    }
                } );
                clip.loop(-1);
                JOptionPane.showMessageDialog(null, startStop);
            }
        };
        SwingUtilities.invokeLater(r);
    }
}