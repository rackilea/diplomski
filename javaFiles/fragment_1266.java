import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class ComponentExample
{
    private CustomPanel drawingBoard;
    private JPanel contentPane;
    private JButton yesButton;
    private JButton noButton;
    private JButton maybeButton;
    private JComboBox cbox;
    private ActionListener buttonAction = new ActionListener()
    {
        @Override
        public void actionPerformed(ActionEvent ae)
        {
            JButton button = (JButton) ae.getSource();

            if (cbox.isShowing())
                    contentPane.remove(cbox);

            if (button == yesButton)
            {
                drawingBoard.setText("You Pressed YES.");           
                contentPane.add(cbox, BorderLayout.PAGE_END);               
            }
            else if (button == noButton)
                drawingBoard.setText("You Pressed NO.");
            else if (button == maybeButton)
                drawingBoard.setText("You Pressed MAYBE.");             

            /*
             * revalidate()/repaint() is needed
             * when the JComponent is added or
             * removed from the already 
             * visible Container.
             */
            contentPane.revalidate();
            contentPane.repaint();
        }
    };

    public ComponentExample()
    {
        cbox = new JComboBox(
                    new String[]{"I GOT IT"
                               , "I STILL HAD DOUBT"});
    }

    private void displayGUI()
    {
        JFrame frame = new JFrame("Component Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        contentPane = new JPanel();
        contentPane.setOpaque(true);
        contentPane.setBackground(Color.DARK_GRAY);
        contentPane.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(5, 5));

        JPanel buttonPanel = new JPanel();
        buttonPanel.setOpaque(true);
        buttonPanel.setBackground(Color.WHITE);

        yesButton = new JButton("YES");
        yesButton.addActionListener(buttonAction);
        noButton = new JButton("NO");
        noButton.addActionListener(buttonAction);
        maybeButton = new JButton("MAY BE");
        maybeButton.addActionListener(buttonAction);
        buttonPanel.add(yesButton);
        buttonPanel.add(noButton);
        buttonPanel.add(maybeButton);

        contentPane.add(buttonPanel, BorderLayout.PAGE_START);

        drawingBoard = new CustomPanel();
        contentPane.add(drawingBoard, BorderLayout.CENTER);

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
                new ComponentExample().displayGUI();
            }
        });
    }
}

class CustomPanel extends JPanel
{
    private String msg;

    public CustomPanel()
    {
        msg = "";
        setOpaque(true);
        setBackground(Color.WHITE);
    }

    public void setText(String msg)
    {
        this.msg = msg;
        repaint();
    }

    @Override
    public Dimension getPreferredSize()
    {
        return (new Dimension(300, 300));
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.drawString(msg, getWidth() / 3, getHeight() / 3);
    }
}