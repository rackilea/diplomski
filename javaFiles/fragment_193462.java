import javax.swing.*;
import java.awt.*;
import net.miginfocom.swing.MigLayout;

public class SimpleGUI
{
    public JFrame myMainWindow = new JFrame("City View");

    JPanel guiPanel = new JPanel();

    JLabel name = new JLabel("Name");
    JLabel ix = new JLabel("ix");
    JLabel iy = new JLabel("iy");
    JLabel factorySpace = new JLabel("Factory Space");
    JLabel storeSpace = new JLabel("Store Space");
    JTextField t1 = new JTextField();
    JTextField t2 = new JTextField();
    JTextField t3 = new JTextField();
    JTextField t4 = new JTextField();
    JTextField t5 = new JTextField();

    public void runGUI()
    {
        myMainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        myMainWindow.setLayout(new GridLayout(1,1));

        createTestPanel();

        myMainWindow.getContentPane().add(guiPanel);

        myMainWindow.setVisible(true);
        myMainWindow.pack();
        myMainWindow.setMinimumSize(new Dimension(myMainWindow.getBounds().getSize()));
    }

    public void createTestPanel()
    {
        MigLayout layout = new MigLayout("wrap 2", "[right][grow]");
        guiPanel.setLayout(layout);

        guiPanel.add(name);
        guiPanel.add(t1,"growx, width 100:100:");
        guiPanel.add(ix);
        guiPanel.add(t2,"growx, width 100:100:");
        guiPanel.add(iy);
        guiPanel.add(t3,"growx, width 100:100:");
        guiPanel.add(factorySpace);
        guiPanel.add(t4,"growx, width 100:100:");
        guiPanel.add(storeSpace);
        guiPanel.add(t5,"growx, width 100:100:");
    }

    public static void main(String[] args)
    {
        SimpleGUI sG = new SimpleGUI();
        sG.runGUI();
    }   
}