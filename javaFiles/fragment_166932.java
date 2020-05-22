import javax.swing.*;

import com.apple.eawt.*;
import com.apple.eawt.AppEvent.*;

public class Foo
    extends JPanel
    implements AboutHandler
{

    public static void main(String[] args)
    throws Exception
    {
        Foo r = new Foo();
    }

    public Foo() {
        Application.getApplication().setAboutHandler(this);
    }

    public void handleAbout(final AboutEvent e) {
        JOptionPane.showMessageDialog(null, "hello, world");
    }

}