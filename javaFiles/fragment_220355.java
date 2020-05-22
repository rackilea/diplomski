import java.awt.GridLayout;
import javax.swing.*;

// <applet code=WhereAmIApplet width=500 height=50></applet>
public class WhereAmIApplet extends JApplet {

    @Override
    public void init() {
        setLayout(new GridLayout(0,1,5,5));
        add(new JLabel("Document Base: " + getDocumentBase()));
        add(new JLabel("Code Base: " + getCodeBase()));
    }
}