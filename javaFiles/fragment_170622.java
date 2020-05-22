import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main extends JFrame {
public Main() {
    JPanel mainPanel = new JPanel(new BorderLayout());
    setContentPane(mainPanel);
    JTextField txtCalc = new JTextField("0");
    txtCalc.setHorizontalAlignment(SwingConstants.RIGHT);

    JPanel buttonPanel = new JPanel(new GridLayout(3, 0));

    JButton btn0 = new JButton("0");
    JButton btn1 = new JButton("1");
    JButton btn2 = new JButton("2");
    JButton btn3 = new JButton("3");
    JButton btn4 = new JButton("4");
    JButton btn5 = new JButton("5");
    JButton btn6 = new JButton("6");
    JButton btn7 = new JButton("7");
    JButton btn8 = new JButton("8");
    JButton btn9 = new JButton("9");

    buttonPanel.add(txtCalc);
    buttonPanel.add(btn0);
    buttonPanel.add(btn1);
    buttonPanel.add(btn2);
    buttonPanel.add(btn3);
    buttonPanel.add(btn4);
    buttonPanel.add(btn5);
    buttonPanel.add(btn6);
    buttonPanel.add(btn7);
    buttonPanel.add(btn8);
    buttonPanel.add(btn9);

    mainPanel.add(txtCalc, BorderLayout.NORTH);
    mainPanel.add(buttonPanel, BorderLayout.CENTER);

    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setTitle("Calculator");
    setSize(600, 600);
    setVisible(true);
}
public static void main(String[] args) {
    SwingUtilities.invokeLater(Main::new);
}
}