package com.test;

 import java.awt.Color;
 import java.awt.SystemColor;
 import java.sql.SQLException;

 import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class PrintChequeGUI extends JFrame {

private JPanel contentPane;
private JTextField txtAmount;

/**
 * Create the frame.
 * 
 * @throws SQLException
 */
public PrintChequeGUI(Cheque cheque) throws SQLException {

    setResizable(false);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100, 100, 480, 400);
    contentPane = new JPanel();
    contentPane.setBackground(new Color(176, 224, 230));
    contentPane.setForeground(SystemColor.inactiveCaption);
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    setContentPane(contentPane);
    contentPane.setLayout(null);

    JPanel panel = new JPanel();
    panel.setBounds(10, 11, 454, 84);
    contentPane.add(panel);

    JPanel panel_1 = new JPanel();
    panel_1.setBackground(new Color(220, 220, 220));
    panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
    panel_1.setBounds(10, 106, 454, 198);
    contentPane.add(panel_1);
    panel_1.setLayout(null);

    JLabel lblNewLabel_1 = new JLabel("Date:");
    lblNewLabel_1.setBounds(327, 11, 40, 14);
    panel_1.add(lblNewLabel_1);

    JLabel lblDate = new JLabel();
    lblDate.setBounds(368, 11, 69, 14);
    panel_1.add(lblDate);

    JLabel lblNewLabel_2 = new JLabel("Payee to the Order of");
    lblNewLabel_2.setBounds(10, 50, 125, 14);
    panel_1.add(lblNewLabel_2);

    JLabel lblName = new JLabel();
    lblName.setBounds(134, 50, 214, 14);
    panel_1.add(lblName);

    JLabel lblRs = new JLabel("Rs.");
    lblRs.setBounds(351, 50, 24, 14);
    panel_1.add(lblRs);

    JLabel lblAmount = new JLabel();
    lblAmount.setBounds(375, 50, 69, 14);
    panel_1.add(lblAmount);

    txtAmount = new JTextField();
    txtAmount.setBounds(10, 83, 338, 20);
    panel_1.add(txtAmount);
    txtAmount.setColumns(10);

    JLabel lblRupees = new JLabel("Rupees");
    lblRupees.setBounds(351, 86, 46, 14);
    panel_1.add(lblRupees);

    JLabel lbl = new JLabel("Cheque Number:");
    lbl.setBounds(10, 126, 100, 14);
    panel_1.add(lbl);

    JLabel lblChequeNum = new JLabel();
    lblChequeNum.setBounds(115, 126, 46, 14);
    panel_1.add(lblChequeNum);

    JLabel lblSig = new JLabel("<<Sig>>");
    lblSig.setBounds(321, 151, 90, 14);
    panel_1.add(lblSig);

    JLabel lblSigName = new JLabel("A.B.C.Test Name");
    lblSigName.setBounds(311, 176, 100, 14);
    panel_1.add(lblSigName);

    JPanel panel_2 = new JPanel();
    panel_2.setBackground(new Color(220, 220, 220));
    panel_2.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
    panel_2.setBounds(10, 315, 454, 40);
    contentPane.add(panel_2);
    panel_2.setLayout(null);

    JButton btnPrint = new JButton("Print");
    btnPrint.setBounds(102, 11, 89, 23);
    panel_2.add(btnPrint);

    JButton btnBack = new JButton("Back");
    btnBack.setBounds(263, 11, 89, 23);
    panel_2.add(btnBack);

    // ChequeGUI gui = new ChequeGUI();
    lblChequeNum.setText(cheque.chqNo);
    lblAmount.setText(Double.toString(cheque.chkAmount));
    lblName.setText(cheque.payName);
    lblDate.setText(String.valueOf(cheque.chkDate));

}
}