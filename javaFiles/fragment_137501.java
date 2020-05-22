import java.awt.*;
import javax.swing.*;

public class ExampleLayout
{
    private void displayGUI()
    {
        JFrame frame = new JFrame("Example Layout");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel contentPane = new JPanel();
        contentPane.setLayout(new BorderLayout(5, 5));

        JPanel basePanel = new JPanel();
        basePanel.setLayout(new GridLayout(0, 1, 5, 5));

        JPanel topPanel = new JPanel();
        //topPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

        JLabel label1 = new JLabel("Label 1", JLabel.CENTER);
        JRadioButton rbut1 = new JRadioButton("RadioButton 1", false);

        topPanel.add(label1);
        topPanel.add(rbut1);        

        JPanel middlePanel = new JPanel();
        middlePanel.setLayout(new GridBagLayout());

        JButton button1 = new JButton("Button 1");

        middlePanel.add(button1);

        basePanel.add(topPanel);
        basePanel.add(middlePanel);

        contentPane.add(basePanel, BorderLayout.PAGE_START);

        frame.setContentPane(contentPane);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    public static void main(String... args)
    {
        EventQueue.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                new ExampleLayout().displayGUI();
            }
        });
    }
}