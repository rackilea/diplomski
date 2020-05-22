import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;

public class TestPSTabbedPaneUI
{
    public static void main(String[] args)
    {
        try
        {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        }
        catch (Exception exc)
        {
            exc.printStackTrace();
        }

        JFrame vFrame = new JFrame();
        vFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vFrame.setSize(200, 200);
        JTabbedPane vTab = new JTabbedPane();
                vTab.setUI(new AizCustomGUI() );

        vTab.add("One", new JPanel());

        JPanel vPanel2 = new JPanel();
        vPanel2.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
        vTab.add("Two", vPanel2);

        vTab.add("Three", new JButton("three"));

        vFrame.getContentPane().add(vTab);
        vFrame.setTitle("Tabs Example");
        vFrame.show();
    }
}