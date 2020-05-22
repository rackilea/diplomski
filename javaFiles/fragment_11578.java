import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MenuActions extends JFrame
{
    private JMenuBar jmb;
    private JMenu file;
    private JMenuItem open;

    public MenuActions()
    {
        jmb = new JMenuBar();
        file = new JMenu("File");
        open = new JMenuItem("Open");
        open.setAction(new MenuAction("Open", null, "Click to Open an Existing File.", KeyStroke.getKeyStroke("control alt P")));
        open.setAccelerator(KeyStroke.getKeyStroke("control alt P"));

        file.add(open);
        jmb.add(file);

        this.setJMenuBar(jmb);

        getContentPane().add(new JPanel());

        this.setSize(200,200);
        this.setVisible(true);
        this.validate();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    private class MenuAction extends AbstractAction
    {
        public MenuAction(String title, ImageIcon image
                                        , String toolTipText
                                        , KeyStroke acceleratorKey)
        {
            super(title, image);
            putValue(SHORT_DESCRIPTION, toolTipText);
            putValue(SHORT_DESCRIPTION, toolTipText);
            putValue(ACCELERATOR_KEY, acceleratorKey);
        }
        public void actionPerformed(ActionEvent ae)
        {
            JOptionPane.showMessageDialog(null,"OK");
        }
    }
    public static void main(String[]args)
    {
        new MenuActions();
    }
}