import java.awt.*;
import java.awt.event.*;

import java.util.Random;

import javax.swing.*;
import javax.swing.border.*;

public class RadioSelection extends JFrame implements ActionListener
{
    private ActionListener action;  
    private JButton[][] button;

    private JPanel bottomPanel;
    private LineBorder lineBorder;

    private int randomRowLimit;
    private int randomColumnLimit;
    private Random random;
    private int size;

    public RadioSelection()
    {
        randomRowLimit = 0;
        randomColumnLimit = 0;
        random = new Random();
        size = 0;

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationByPlatform(true);

        lineBorder = new LineBorder(Color.BLUE.darker());

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

        bottomPanel = new JPanel();

        final JRadioButton threeSquareButton = new JRadioButton("3 X 3", false);
        final JRadioButton fourSquareButton = new JRadioButton("4 X 4", false);
        final JRadioButton fiveSquareButton = new JRadioButton("5 X 5", false);

        threeSquareButton.setBorder(lineBorder);
        fourSquareButton.setBorder(lineBorder);
        fiveSquareButton.setBorder(lineBorder);

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
                else if (ae.getSource() == fiveSquareButton)
                {
                    remove(bottomPanel);
                    bottomPanel = getCenterPanel(5);
                    add(bottomPanel, BorderLayout.CENTER);
                }
                revalidate(); // If you are using JDK 1.7 +
                // getContentPane().revalidate(); // if you using JDK 1.6 or lower
                repaint();
            }
        };

        threeSquareButton.addActionListener(action);
        fourSquareButton.addActionListener(action);
        fiveSquareButton.addActionListener(action);

        ButtonGroup bg = new ButtonGroup();
        bg.add(threeSquareButton);
        bg.add(fourSquareButton);
        bg.add(fiveSquareButton);

        topPanel.add(threeSquareButton);
        topPanel.add(fourSquareButton);
        topPanel.add(fiveSquareButton);

        add(topPanel, BorderLayout.PAGE_START);
        add(bottomPanel, BorderLayout.CENTER);

        setSize(300, 300);
        //pack();
        setVisible(true);
    }

    private JPanel getCenterPanel(int size)
    {
        JPanel bottomPanel = new JPanel(new GridLayout(size, size));
        button = new JButton[size][size];
        this.size = size;

        for (int row = 0; row < size; row++)
        {
            for (int column = 0; column < size; column++)
            {
                button[row][column] = new JButton();
                button[row][column].setBorder(lineBorder);
                button[row][column].setMargin(new Insets(2, 2, 2, 2));
                button[row][column].addActionListener(this);
                bottomPanel.add(button[row][column]);
            }
        }

        randomRowLimit = random.nextInt(size);
        randomColumnLimit = random.nextInt(size);
        button[randomRowLimit][randomColumnLimit].setText("X");

        return bottomPanel;
    }

    public void actionPerformed(ActionEvent ae)
    {
        JButton button = (JButton) ae.getSource();

        if ((button.getText()).equals("X"))
        {
            randomRowLimit = random.nextInt(size);
            randomColumnLimit = random.nextInt(size);
            System.out.println("Row : " + randomRowLimit);
            System.out.println("Column : " + randomColumnLimit);
            button.setText("");
            this.button[randomRowLimit][randomColumnLimit].setText("X");            
        }
        else
        {
            JOptionPane.showMessageDialog(this, "Please Click on X Mark to follow it.", "Small Game : ", JOptionPane.ERROR_MESSAGE);
        }
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