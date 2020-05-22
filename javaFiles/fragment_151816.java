import java.net.URL;
import javax.sound.sampled.*;
import javax.swing.*;
import javax.swing.event.*;

public class VolumeControl {

    public static void main(String[] args) throws Exception {
        URL url = new URL(
            "http://pscode.org/media/leftright.wav");
        Clip clip = AudioSystem.getClip();
        // getAudioInputStream() also accepts a File or InputStream
        AudioInputStream ais = AudioSystem.
            getAudioInputStream( url );
        clip.open(ais);
        Control[] c = clip.getControls();
        FloatControl temp = null;
        for (Control control : c) {
            System.out.println(control);
            if (control.toString().toLowerCase().contains("master gain")) {
                // we found it!
                temp = (FloatControl)control;
            }
        }
        final FloatControl vol = temp;
        clip.loop(Clip.LOOP_CONTINUOUSLY);
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JComponent c = null;
                if (vol!=null) {
                    final JSlider volControl = new JSlider(
                            (int)(100*vol.getMinimum()),
                            (int)(100*vol.getMaximum()),
                            (int)(100*vol.getValue())
                            );
                    ChangeListener cl = new ChangeListener() {

                        @Override
                        public void stateChanged(ChangeEvent e) {
                            System.out.println( "Vol: " + volControl.getValue()/100f );
                            vol.setValue(volControl.getValue()/100f);
                        }
                    };
                    volControl.addChangeListener(cl);
                    c = volControl;
                } else {
                    c = new JLabel("Close to exit!");
                }
                JOptionPane.showMessageDialog(null, c);
            }
        });
    }
}