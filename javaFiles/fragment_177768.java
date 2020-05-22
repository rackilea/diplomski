import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * Created with IntelliJ IDEA.
 * User: Gagandeep Bali
 * Date: 1/14/13
 * Time: 7:34 PM
 * To change this template use File | Settings | File Templates.
 */
public class FrameFocus
{
    private JFrame mainwindow;
    private CustomDialog customDialog;

    private void displayGUI()
    {
        mainwindow = new JFrame("Frame Focus Window Example");
        customDialog = new CustomDialog(mainwindow, "Modal Dialog", true);
        mainwindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel contentPane = new JPanel();
        JButton mainButton = new JButton(
                "Click me to open a MODAL Dialog");
        mainButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!customDialog.isShowing())
                    customDialog.setVisible(true);
            }
        });
        contentPane.add(mainButton);
        mainwindow.setContentPane(contentPane);
        mainwindow.pack();
        mainwindow.setLocationByPlatform(true);
        mainwindow.setVisible(true);
    }

    public static void main(String... args)
    {
        EventQueue.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                new FrameFocus().displayGUI();
            }
        });
    }
}


class CustomDialog extends JDialog
{
    private JFrame mainWindow;
    public CustomDialog(JFrame owner, String title, boolean modal)
    {
        super(owner, title, modal);
        mainWindow = owner;
        JPanel contentPane = new JPanel();
        JLabel dialogLabel = new JLabel(
                "I am a Label on JDialog.", JLabel.CENTER);
        contentPane.add(dialogLabel);
        setContentPane(contentPane);
        pack();

        addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                mainWindow.setLocationRelativeTo(null);
                setLocationRelativeTo(null);
            }

            @Override
            public void focusLost(FocusEvent e) {
                /*
                 * Nothing written for this part yet
                 */
            }
        });
    }
}