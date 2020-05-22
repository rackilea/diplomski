import javax.swing.*;
import java.net.*;

public class TestIcon
{
    public static void main(String[] args) throws Exception
    {
        final ImageIcon icon = new ImageIcon(new URL("http://www.gravatar.com/avatar/a1ab0af4997654345d7a949877f8037e?s=128&d=identicon&r=PG"));
        JOptionPane.showMessageDialog(null, "Blah blah blah", "About", JOptionPane.INFORMATION_MESSAGE, icon);
    }
}