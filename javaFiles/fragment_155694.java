import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class DrumApplet extends Applet implements KeyListener{

    //declaring Audio variables
    AudioClip kick, snare, hat_close, hat_opem, crash, tom;

    @Override
    public void init(){
        kick = this.getAudioClip(getDocumentBase(), "kick.wav");
        snare = this.getAudioClip(getDocumentBase(), "snare.wav");
        //load all other audio samples

        addKeyListener(this); //to detect the press of a key
    }

    @Override
    public void paint(Graphics g){
        //display message as to which key to press to play a sound
    }

    @Override
    public void keyPressed(KeyEvent K){

        char X = K.getKeyCode();
        if(X == 'K')
        kick.play(); //play kick.wav when K is pressed

        if(X == 'S')
        snare.play(); //play snare.wav when S is pressed

        if(X == 'T')
        tom.play(); //play tom.wav when T is pressed

        if(X == 'O')
        hat_open.play(); //play hat_open.wav when O is pressed

        //write if statements for the rest of the Keys

        repaint();
    }

    @Override
    public void keyReleased(KeyEvent K){}

    @Override
    public void keyTyped(KeyEvent K){}

}