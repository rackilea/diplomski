import java.awt.*;
import javax.swing.*;

public class PanelAddition
{
    private void createAndDisplayGUI()
    {
        JFrame frame = new JFrame("Panel Addition Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel contentPane = new JPanel();
        contentPane.setLayout(new GridLayout(0, 1));        
        JScrollPane scroller = new JScrollPane();

        CustomPanel panel = new CustomPanel(1);
        contentPane.add(panel);
        scroller.setViewportView(contentPane);
        frame.getContentPane().add(scroller, BorderLayout.CENTER);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);

        for (int i = 2; i < 20; i++)
        {
            CustomPanel pane = new CustomPanel(i);
            contentPane.add(pane);
            contentPane.revalidate();
            contentPane.repaint();
        }
    }

    public static void main(String... args)
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                new PanelAddition().createAndDisplayGUI();
            }
        });
    }
}

class CustomPanel extends JPanel
{

    public CustomPanel(int num)
    {
        JLabel label = new JLabel("" + num);
        add(label);
    }

    @Override
    public Dimension getPreferredSize()
    {
        return (new Dimension(200, 50));
    }
}