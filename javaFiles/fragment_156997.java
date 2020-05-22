import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class WindowExample
{
    private JWindow window;
    private JLabel updateLabel;
    private int count = 5;
    private Timer timer;
    private int x;
    private int y;
    private ActionListener timerAction = new ActionListener()
    {
        public void actionPerformed(ActionEvent ae)
        {
            updateLabel.setText("Closing Window in " + count + " seconds...");
            count--;
            if (count == 0)
            {
                timer.stop();
                window.setVisible(false);
                window.dispose();
            }   
        }
    };

    private void createAndDisplayGUI()
    {
        final JFrame frame = new JFrame("Window Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setUndecorated(true);
        frame.setOpacity(0.5f);
        frame.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent me)
            {
                x = me.getX();
                y = me.getY();
                window = new JWindow();
                JPanel contentPane = new JPanel();
                JLabel positionLabel = new JLabel(
                    "X : " + me.getX() + " Y : " + me.getY());
                updateLabel = new JLabel("TImer");  
                contentPane.setLayout(new BorderLayout(5, 5));
                contentPane.add(updateLabel, BorderLayout.CENTER);
                contentPane.add(positionLabel, BorderLayout.PAGE_END);
                window.setContentPane(contentPane);
                window.setOpacity(0.5f);
                window.setSize(200, 100);
                window.setLocation(x + window.getWidth(), y + window.getHeight());
                window.setVisible(true);
                count = 5;
                timer = new Timer(1000, timerAction);
                timer.start();
            }
        });

        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String... args)
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                new WindowExample().createAndDisplayGUI();
            }
        });
    }
}