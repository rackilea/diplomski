import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;

public class Driver extends JFrame{
    private JTextField jtfDeposit = new JTextField("0.00");
    private JTextField jtfWithdraw = new JTextField("0.00");
    private JTextField jtfTransfer = new JTextField("0.00");
    private JTextField jtfCBalance = new JTextField("0.00");
    private JTextField jtfSBalance = new JTextField("0.00");
    private JComboBox jtfCombo = null; /* NEW */

    private JButton jbtDeposit = new JButton("Deposit");
    private JButton jbtWithdraw = new JButton("Withdraw");
    private JButton jbtTransfer = new JButton("Transfer");

    String[] depositStrings = { "Checking", "Savings"};
    String[] withdrawStrings = { "Checking", "Savings"};
    String[] transferStrings = { "CHK* to SAVA*", "SAVA* to CHK*"};

    public Driver(){
        JPanel p1 = new JPanel(new GridLayout(3,4));
        p1.add(new JLabel("Deposit Into: "));

        jtfCombo = new JComboBox(depositStrings); /* NEW */
        p1.add(jtfCombo); /* NEW */
        p1.add(jtfDeposit);
        p1.add(jbtDeposit);

        p1.add(new JLabel("Withdraw From: "));
        p1.add(new JComboBox(withdrawStrings));
        p1.add(jtfWithdraw);
        p1.add(jbtWithdraw);

        p1.add(new JLabel("Transfer From: "));
        p1.add(new JComboBox(transferStrings));
        p1.add(jtfTransfer);
        p1.add(jbtTransfer);

        p1.setBorder(new TitledBorder("WELCOME TO THE BANK OF IS247"));

        JPanel p2 = new JPanel(new GridLayout(2,2));
        p2.add(new JLabel("Checking : "));
        p2.add(jtfCBalance);
        p2.add(new JLabel("Savings : "));
        p2.add(jtfSBalance);

        p2.setBorder(new TitledBorder("YOUR BALANCES"));

        add(p1, BorderLayout.CENTER);
        add(p2, BorderLayout.SOUTH);

        jbtDeposit.addActionListener(new ButtonListener());
        jbtWithdraw.addActionListener(new ButtonListener());
        jbtTransfer.addActionListener(new ButtonListener());
    }
    class ButtonListener implements ActionListener{
        Account cAcc = new CheckingAccount();
        Account sAcc = new SavingAccount();

        @Override
        public void actionPerformed(ActionEvent e){
            String actionCommand = e.getActionCommand();
            switch (actionCommand){
            case "Deposit":
                if(jtfCombo.getSelectedItem().equals(depositStrings[0])){ /* NEW */
                    System.out.println("depositing to checking..."); /* NEW */
                    function(1);
                    break;
                }else if(jtfCombo.getSelectedItem().equals(depositStrings[1])){
                    System.out.println("depositing to savings..."); /* NEW */
                    function(2);
                    break;
                }
                break; /* NEW */
            case "Withdraw":
                if("Withdraw".equals(withdrawStrings[0])){
                    function(3);
                    break;
                }else if("Withdraw".equals(withdrawStrings[1])){
                    function(4);
                    break;
                }
                break; /* NEW */
            case "Transfer":
                if("Transfer".equals(transferStrings[0])){
                    function(5);
                    break;
                }else if("Transfer".equals(transferStrings[1])){
                    function(6);
                }
                break; /* NEW */
            }
        }
        private void function(int num){
            double dAmount = new Double(jtfDeposit.getText().trim()).doubleValue();
            double wAmount = new Double(jtfWithdraw.getText().trim()).doubleValue();
            double tAmount = new Double(jtfTransfer.getText().trim()).doubleValue();
            double cAmount = cAcc.getBalance();
            double sAmount = sAcc.getBalance();

            switch (num){
            case 1:
                cAmount = cAcc.getDeposit(dAmount);
                break;
            case 2:
                sAmount = sAcc.getDeposit(dAmount);
                break;
            case 3:
                cAmount = cAcc.getWithdrawal(wAmount);
                break;
            case 4:
                sAmount = sAcc.getWithdrawal(wAmount);
                break;
            case 5:
                cAmount = cAcc.getTransfer(tAmount);
                sAmount = sAcc.getDeposit(tAmount);
                break;
            case 6:
                sAmount = sAcc.getTransfer(tAmount);
                cAmount = cAcc.getDeposit(tAmount);
                break;
            }
            jtfCBalance.setText(String.valueOf(cAmount));
            jtfSBalance.setText(String.valueOf(sAmount));
        }
    }
    public static void main(String[] args){
        Driver frame = new Driver();
        frame.setTitle("Bank of IS247");
        frame.setSize(500,200);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}