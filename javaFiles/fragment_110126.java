import javax.swing.*;
import javax.swing.border.*;

public class MortgageCalculatorGUI7 extends JFrame {


    JPanel panel1 = new JPanel();

    public MortgageCalculatorGUI7() {

        getContentPane().setLayout(null);
        setSize(400, 400);

        panel1.setLayout(null);
        panel1.setBounds(0, 0 , 400, 400);
        add(panel1);


        JLabel label1 = new JLabel("a label");
        label1.setBounds(15, 15, 150, 30);
        label1.setBorder(new BevelBorder(BevelBorder.RAISED));
        panel1.add(label1);


        JLabel label2 = new JLabel("a label");
        label2.setBounds(100, 100, 150, 30);
        label2.setBorder(new BevelBorder(BevelBorder.RAISED));
        panel1.add(label2);

        JLabel label3 = new JLabel("a label");
        label3.setBounds(200, 200, 150, 30);
        label3.setBorder(new BevelBorder(BevelBorder.RAISED));
        panel1.add(label3);


    }

    public static void main(String[] args) {
        MortgageCalculatorGUI7 mortgageCalculatorGUI7 = new MortgageCalculatorGUI7();
        mortgageCalculatorGUI7.setDefaultCloseOperation(EXIT_ON_CLOSE);
        mortgageCalculatorGUI7.setVisible(true);

    }

}