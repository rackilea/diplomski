import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class RadioSelection extends JFrame
{
    private ActionListener action;  
    private JPanel bottomPanel;
    private LineBorder lineBorder ;

    public RadioSelection()
    {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationByPlatform(true);

        lineBorder = new LineBorder(Color.BLUE.darker());

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

        bottomPanel = new JPanel();

        final JRadioButton threeSquareButton = new JRadioButton("3 X 3", false);
        final JRadioButton fourSquareButton = new JRadioButton("4 X 4", false);

        threeSquareButton.setBorder(lineBorder);
        fourSquareButton.setBorder(lineBorder);

        action = new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                if (ae.getSource() == threeSquareButton)
                {
                    remove(bottomPanel);
                    bottomPanel = getCenterPanel(3);
                    add(bottomPanel, BorderLayout.CENTER);
                }
                else if (ae.getSource() == fourSquareButton)
                {
                    remove(bottomPanel);
                    bottomPanel = getCenterPanel(4);
                    add(bottomPanel, BorderLayout.CENTER);
                }
                revalidate(); // If you are using JDK 1.7 +
                // getContentPane().revalidate(); // if you using JDK 1.6 or lower
                repaint();
            }
        };

        threeSquareButton.addActionListener(action);
        fourSquareButton.addActionListener(action);

        ButtonGroup bg = new ButtonGroup();
        bg.add(threeSquareButton);
        bg.add(fourSquareButton);

        topPanel.add(threeSquareButton);
        topPanel.add(fourSquareButton);

        add(topPanel, BorderLayout.PAGE_START);
        add(bottomPanel, BorderLayout.CENTER);

        setSize(300, 300);
        setVisible(true);
    }

    private JPanel getCenterPanel(int size)
    {
        JPanel bottomPanel = new JPanel(new GridLayout(size, size));

        for (int row = 0; row < size; row++)
        {
            for (int column = 0; column < size; column++)
            {
                JButton button = new JButton("Button " + row + " " + column);
                button.setBorder(lineBorder);
                button.setMargin(new Insets(2, 2, 2, 2));
                bottomPanel.add(button);
            }
        }

        return bottomPanel;
    }

    public static void main(String... args)
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                new RadioSelection();
            }
        });
    }
}