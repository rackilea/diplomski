import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Label;

/**
 *
 * @author hmmmmm
 */
public class MessageApplet extends Applet {

    private Label m_mess;

    public void init() {
        setBackground(Color.lightGray);
        setLayout(new BorderLayout());
        m_mess = new Label("MessageApplet is Running... : No Selection Yet", Label.CENTER);
        add(BorderLayout.CENTER, m_mess);
        m_mess.setBackground(Color.red);
    }

    public void setMessage(String message) {
        m_mess.setText("Selection : " + message);
    }
}