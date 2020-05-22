package play;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.swing.JButton;
import javax.swing.JFrame;

public class AudioPlay  {

    private Clip clip;
    JFrame f = new JFrame();
   // Constructor
   public AudioPlay() {
        try {
            this.clip = AudioSystem.getClip();
        } catch (LineUnavailableException ex) {
            Logger.getLogger(AudioPlay.class.getName()).log(Level.SEVERE, null, ex);
        }



      f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      f.setTitle("Test Sound Clip");
      f.setSize(300, 200);
      f.setLayout(new FlowLayout());

      JButton button = new JButton("play");
        button.addActionListener(new  ActionListener() {
           public void actionPerformed(ActionEvent e) {                    
             playSound(0);                                     
           }
        });            



        f.add(button);

        //f.setVisible(true);

   }

   public void stopSound() {
        clip.stop();   
        //clip.flush();
        clip.close();

    }

   public void playSound(int a){

       // Open an audio input stream.
       String[] sounds = new String[10];
       sounds[0]= "rs/Tr-3L_nA_sus_mf_D4.wav";
       sounds[1]= "rs/Tr-3L_nA_sus_mf_F#4.wav";
       File f = new File(sounds[a]);
       try {
         URL url = f.toURI().toURL();
         AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);

         // Open audio clip and load samples from the audio input stream.
         clip.open(audioIn);
         clip.start();            

      } catch (Exception e) {
         e.printStackTrace();
         System.out.println(e + " " + f);
      }

}

   public static void main(String[] args) {
       AudioPlay ap = new AudioPlay();
       Other oth = new Other(ap, ap.f);
       ap.shw();
   }

   public void shw(){
       f.setVisible(true);
   }
}