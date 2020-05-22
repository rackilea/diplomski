import java.awt.*;
import javax.swing.*;

public class ExampleLayout
{
    private void displayGUI()
    {
        JFrame frame = new JFrame("Example Layout");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel contentPane = new JPanel();
        contentPane.setLayout(new GridLayout(0, 1, 5, 5));

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

        JRadioButton rbut1 = new JRadioButton("RadioButton 1", false);
        JTextField tfield1 = new JTextField(10);
        JButton button1 = new JButton("Button 1");

        topPanel.add(rbut1);
        topPanel.add(tfield1);
        topPanel.add(button1);

        JPanel middlePanel = new JPanel();
        middlePanel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

        JRadioButton rbut2 = new JRadioButton("RadioButton 2", false);
        JTextField tfield2 = new JTextField(10);
        JButton button2 = new JButton("Button 2");

        middlePanel.add(rbut2);
        middlePanel.add(tfield2);
        middlePanel.add(button2);

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
        JCheckBox cbox = new JCheckBox("CheckBox 1", false);
        bottomPanel.add(cbox);

        contentPane.add(topPanel);
        contentPane.add(middlePanel);
        contentPane.add(bottomPanel);

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