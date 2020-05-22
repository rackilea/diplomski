import javax.swing.*;
import javax.swing.text.html.parser.ParserDelegator;

public class HelloWorldApplet extends JApplet {
    public void init() {
       ParserDelegator workaround = new ParserDelegator();
       applet.add(new JLabel("Hello Everybody (Text)"), java.awt.BorderLayout.NORTH);
       applet.add(new JLabel("<html>Hello Everybody (HTML)</html>"),  java.awt.BorderLayout.SOUTH);
    }
}