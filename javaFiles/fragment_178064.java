/* <!-- Defines the applet element used by the appletviewer. -->
<applet code='HelloWorld' width='200' height='100'></applet> */
import javax.swing.*;

/** An 'Hello World' Swing based applet.

To compile and launch:
prompt> javac HelloWorld.java
prompt> appletviewer HelloWorld.java  */
public class HelloWorld extends JApplet {

    public void init() {
        // Swing operations need to be performed on the EDT.
        // The Runnable/invokeLater() ensures that happens.
        Runnable r = new Runnable() {
            public void run() {
                // the crux of this simple applet
                getContentPane().add( new JLabel("Hello World!") );
            }
        };
        SwingUtilities.invokeLater(r);
    }
}