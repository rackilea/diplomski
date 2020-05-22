import java.awt.Dimension;
import javax.swing.*;

public class ScrolledPane extends JPanel
{
    private JScrollPane vertical;
    private JTextArea console;

    public ScrolledPane()
    {
        setPreferredSize(new Dimension(200, 250));
        console = new JTextArea(15, 15);

        vertical = new JScrollPane(console);
        vertical.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        add(vertical);
    }


    public static void main( String args[] )
    {
        new JFrame()
        {{
            getContentPane().add(new ScrolledPane());
            pack();
            setVisible(true);
        }};
    }
}