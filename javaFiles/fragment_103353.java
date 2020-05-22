import java.awt.Color;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;



public class Test
{
    public static void main(String[] args)
    {
        Frame frame = new Frame("Title");
        frame.setSize(400, 400);
        frame.setLocationRelativeTo(null);
        frame.addWindowListener(new WindowAdapter() {
            @Override public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        frame.setBackground(Color.BLUE);

        frame.setVisible(true);
    }
}