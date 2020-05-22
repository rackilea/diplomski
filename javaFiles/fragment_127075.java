import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.EventHandler;
import javax.swing.*;

public class DialogWithScroller
{
    private JFrame frame;
    private JButton showButton;
    private MyDialog myDialog;

    private void displayGUI()
    {
        frame = new JFrame("Dialog ScrollPane Example");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel contentPane = new JPanel(new BorderLayout(5, 5));
        showButton = new JButton("Show Dialog");
        showButton.addActionListener((ActionListener)
                EventHandler.create(ActionListener.class,
                        DialogWithScroller.this, "buttonActions", ""));     
        contentPane.add(showButton);

        frame.setContentPane(contentPane);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }   

    public void buttonActions(ActionEvent ae)
    {
        myDialog = new MyDialog(frame
                , "TextArea with ScrollPane", true);
    }

    public static void main(String[] args)
    {
        Runnable runnable = new Runnable()
        {
            @Override
            public void run()
            {
                new DialogWithScroller().displayGUI();
            }
        };
        EventQueue.invokeLater(runnable);
    }
}

class MyDialog extends JDialog
{
    private JTextArea tArea;
    private JButton hideButton;

    private ActionListener buttonActions =
                            new ActionListener()
    {
        @Override
        public void actionPerformed(ActionEvent ae)
        {
            MyDialog.this.dispose();
        }
    };

    public MyDialog()
    {}

    public MyDialog(Frame owner, String title, boolean modal)
    {
        super(owner, title, modal);
        displayGUI();
    }

    private void displayGUI()
    {
        JPanel contentPane = new JPanel(
                        new BorderLayout(5, 5));
        contentPane.setBorder(
                BorderFactory.createTitledBorder(
                            "My Personal Text Area"));
        /*
         * Here one can simply initialize the
         * JTextArea like this too, using the
         * constructor itself for specifying
         * the Rows and Columns, which will
         * help the layout concern to determine
         * its size
         */
        tArea = new JTextArea(20, 20);
        tArea.setLineWrap(true);
        tArea.setWrapStyleWord(true);
        JScrollPane textScroller = new JScrollPane(tArea);
        //textScroller.setViewportView(tArea);

        hideButton = new JButton("Hide Dialog");
        hideButton.addActionListener(buttonActions);

        contentPane.add(textScroller, BorderLayout.CENTER);
        contentPane.add(hideButton, BorderLayout.PAGE_END);
        setContentPane(contentPane);
        pack();
        setLocationByPlatform(true);
        setVisible(true);
    }   
}