import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class SwingTest {
    public static void main( String [] args ) {
        final JFrame frame = getFrame();
        frame.pack();        
        frame.setVisible( true );
        Runtime.getRuntime().addShutdownHook(new Thread() {
            public void run() {
                writeToFile( frame, "swingtest.ser");
            } 
        });
    }

    /**
     * Reads it serialized or create a new one if it doens't exists
     */ 
    private static JFrame getFrame(){
        File file = new File("swingtest.ser");
        if( !file.exists() ) {
            System.out.println("creating a new one");
            JFrame frame = new JFrame();
            JPanel panel = new JPanel();
            panel.add( new JLabel("Some test here:"));
            panel.add( new JTextField(10));
            frame.add( panel );
            return frame;
        } else {
            return ( JFrame ) readObjectFrom( file );
        }
    }