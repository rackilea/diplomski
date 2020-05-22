import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CardLayoutExample
{
    private JPanel contentPane;
    private MyPanel panel1;
    private MyPanel2 panel2;

    private void displayGUI()
    {
        JFrame frame = new JFrame("Card Layout Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel contentPane = new JPanel();
        contentPane.setBorder(
            BorderFactory.createEmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new CardLayout());
        panel1 = new MyPanel(contentPane);
        panel2 = new MyPanel2(contentPane);
        contentPane.add(panel1, "Panel 1"); 
        contentPane.add(panel2, "Panel 2");
        frame.setContentPane(contentPane);
        frame.pack();   
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    public static void main(String... args)
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                new CardLayoutExample().displayGUI();
            }
        });
    }
}

class MyPanel extends JPanel 
{
    private JButton jcomp4;
    private JPanel contentPane;

    public MyPanel(JPanel panel) 
    {
        contentPane = panel;
        setOpaque(true);
        setBackground(Color.RED.darker().darker());
        //construct components
        jcomp4 = new JButton ("openNewWindow");
        jcomp4.addActionListener( new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                CardLayout cardLayout = (CardLayout) contentPane.getLayout();
                cardLayout.next(contentPane);
            }
        });
        add(jcomp4);
    }

    @Override
    public Dimension getPreferredSize()
    {
        return (new Dimension(500, 500));
    }
}

class MyPanel2 extends JPanel 
{

    private JButton jcomp1;
    private JPanel contentPane;

    public MyPanel2(JPanel panel) 
    {   
        contentPane = panel;

        setOpaque(true);
        setBackground(Color.GREEN.darker().darker());

        //construct components
        jcomp1 = new JButton ("Back");
        jcomp1.addActionListener( new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                CardLayout cardLayout = (CardLayout) contentPane.getLayout();
                cardLayout.next(contentPane);
            }
        });

        add(jcomp1);
    }

    @Override
    public Dimension getPreferredSize()
    {
        return (new Dimension(500, 500));
    }
}