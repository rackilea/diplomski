import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Binary {

    private JLabel header;
    private JTextField userInput1;
    private JButton doIt;
    private JButton clear;
    private JRadioButton binary, decimal;
    private JLabel number2;
    private JFrame frame1;
    private JPanel panel1;
    private JPanel panel2;

    public Binary() {

        frame1 = new JFrame("Binary to Decimal Converter");
        frame1.setLayout(new FlowLayout());
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel1 = new JPanel();
        panel1.setSize(250, 450);
        frame1.add(panel1);

        header = new JLabel("1- Select the mode: ");
        panel1.add(header);

        panel2 = new JPanel();
        panel2.setSize(250, 25);
        panel2.setOpaque(true);
        panel2.setBackground(Color.GRAY);
        frame1.add(panel2);

        ButtonGroup choices = new ButtonGroup();
        binary = new JRadioButton("Binary to Decimal"); // add the first radiobutton binary to decimal
        choices.add(binary);
        decimal = new JRadioButton("Decimal to Binary"); // add the second radiobutton decimal to binary
        choices.add(decimal);
        frame1.add(binary); // adds both to the program
        frame1.add(decimal);

        userInput1 = new JTextField(20); // Adds a blank text field for user input
        frame1.add(userInput1);

        number2 = new JLabel("2- Enter some words then click Do It:");
        frame1.add(number2);

        doIt = new JButton("Do It"); // left button do it
        frame1.add(doIt);

        clear = new JButton("Clear"); // right button clear
        frame1.add(clear);

        frame1.pack();
        frame1.setVisible(true);
    }

}