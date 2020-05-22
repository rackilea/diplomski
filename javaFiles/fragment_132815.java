import java.awt.*;    
import javax.swing.*;    
import java.awt.event.*;
import java.io.*;

public class GUI_Amortization_Calculator extends JFrame {

    private JPanel contentPane;
    private JTextField textLoanAmount;
    private JTextField textYears;
    private JTextField textInterestRate;
    private JTextArea calculation;
    /**
     * @wbp.nonvisual location=71,9
     */
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    GUI_Amortization_Calculator frame = new GUI_Amortization_Calculator();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public GUI_Amortization_Calculator() {

        System.setOut(new PrintStream(new OutputStream(){

            @Override
            public void write(int b) throws IOException {
                // redirects data to the text area
                calculation.append(String.valueOf((char)b));
                // scrolls the text area to the end of data
                calculation.setCaretPosition(calculation.getDocument().getLength());
            }

        }));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 650, 600);
        getContentPane().setLayout(null);

        JPanel panel_2 = new JPanel();
        panel_2.setBounds(10, 11, 614, 34);
        getContentPane().add(panel_2);

        JLabel IntroLabel = new JLabel("Introduction to Java Class GUI Amortization Mortgage Calculator by Beth Pizana");
        IntroLabel.setForeground(Color.MAGENTA);
        IntroLabel.setFont(new Font("Arial Black", Font.BOLD, 12));
        panel_2.add(IntroLabel);

        JPanel panel = new JPanel();
        panel.setBounds(10, 56, 198, 495);
        getContentPane().add(panel);

        JLabel loanAmountLabel = new JLabel("Enter your loan amount:");
        loanAmountLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        panel.add(loanAmountLabel);

        textLoanAmount = new JTextField();
        textLoanAmount.setFont(new Font("Arial", Font.PLAIN, 12));
        panel.add(textLoanAmount);
        textLoanAmount.setColumns(15);
        //String txtLoanAmount = textLoanAmount.getText();

        JLabel yearsLabel = new JLabel("Enter the years of your loan:");
        yearsLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        panel.add(yearsLabel);

        textYears = new JTextField();
        textYears.setFont(new Font("Arial", Font.PLAIN, 12));
        panel.add(textYears);
        textYears.setColumns(15);
        //String txtYears = textYears.getText();

        JLabel interestRateLavel = new JLabel("Enter the interest rate of your loan:");
        interestRateLavel.setFont(new Font("Arial", Font.PLAIN, 12));
        panel.add(interestRateLavel);

        textInterestRate = new JTextField();
        textInterestRate.setFont(new Font("Arial", Font.PLAIN, 12));
        panel.add(textInterestRate);
        textInterestRate.setColumns(15);
        //String txtInterestRate = textInterestRate.getText();

        JButton calculate = new JButton("Calculate");
        calculate.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                Double loanAmount = Double.parseDouble(textLoanAmount.getText());
                int years = Integer.parseInt(textYears.getText());
                Double interestRate = Double.parseDouble(textInterestRate.getText());
                //String calc  = calculation.getText();
                calcAmortization(loanAmount, years, interestRate);
                //textarea.append(calc);

            }
        });

        calculate.setFont(new Font("Arial", Font.PLAIN, 12));
        panel.add(calculate);

        JButton reset = new JButton("Reset");
        reset.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                textLoanAmount.setText("");
                textYears.setText("");
                textInterestRate.setText("");
            }
        });
        reset.setFont(new Font("Arial", Font.PLAIN, 12));
        panel.add(reset);

        calculation = new JTextArea();

        calculation.setColumns(6);
        JScrollPane p = new JScrollPane(calculation);
        p.setBounds(228, 51, 380, 500);
        getContentPane().add(p);

    }
    public static void calcAmortization(double loanAmount, int numYears, double interestRate){
        double newBalance;
        //Calculate the monthly interest rate
        double monthlyInterestRate = (interestRate / 12)/100;
        //Calculate the number of months
        int totalMonths = numYears * 12;
        double monthlyPayment, interestPayment, principalPayment;
        int count;

        //Calculate the monthly payment
        monthlyPayment = loanAmount * monthlyInterestRate * Math.pow(1 + monthlyInterestRate, (double)totalMonths)/(Math.pow(1 + monthlyInterestRate, (double)totalMonths)-1);

        printTableHeader();

        for (count = 1; count < totalMonths; count++){
            interestPayment = loanAmount * monthlyInterestRate;
            principalPayment = monthlyPayment - interestPayment;
            newBalance = loanAmount - principalPayment;
            printSchedule(count, loanAmount, monthlyPayment, interestPayment, principalPayment, newBalance);
            loanAmount = newBalance;
        }
    }
    public static void printSchedule(int count, double loanAmount, double monthlyPayment, double interestPayment, double principalPayment, double newBalance){

        System.out.format("%-8d$%,-12.2f$%,-10.2f$%,-10.2f$%,-10.2f$%,-12.2f\n",count,loanAmount,monthlyPayment,interestPayment,principalPayment,newBalance);

    }
    public static void printTableHeader(){
        int count;
        System.out.println("\nAmortization Schedule for  Borrower");
        for(count=0;count<62;count++) System.out.print("-");
        System.out.format("\n%-10s%-11s%-12s%-11s%-11s%-12s"," ","Old","Monthly","Interest","Principal","New","Balance");
        System.out.format("\n%-10s%-11s%-12s%-11s%-11s%-12s\n\n","Month","Balance","Payment","Paid","Paid","Balance");
    }
}