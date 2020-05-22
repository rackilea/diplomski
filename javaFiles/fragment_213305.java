import java.applet.JApplet;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class myJFrame {
private final MainMenu main;
private SidePanel side;
private JApplet parent;

public myJFrame(JApplet ja) {
    parent = ja;
    ...
}
...
}