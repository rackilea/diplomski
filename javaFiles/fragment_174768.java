import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.*;
/*
 * Created by JFormDesigner on Wed May 11 16:42:17 PDT 2011
 */

public class UsernameForm extends JFrame {

    UsernameForm() {
        initComponents();
        pack();
    }

    private void passwordField1KeyPressed(KeyEvent e) {
        // TODO add your code here
    }

    private void button1ActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void textArea1MouseClicked(MouseEvent e) {
        // TODO add your code here
    }

    private void textArea1FocusGained(FocusEvent e) {
        // TODO add your code here
    }

    private void textArea1FocusLost(FocusEvent e) {
        // TODO add your code here
    }

    private void button2ActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - ryan icknem
        usernameChecker = new JPanel();
        panel1 = new JPanel();
        textField1 = new JTextField();
        passwordField1 = new JPasswordField();
        button1 = new JButton();
        label1 = new JLabel();
        label2 = new JLabel();
        scrollPane1 = new JScrollPane();
        textArea1 = new JTextArea();
        button2 = new JButton();

        //======== usernameChecker ========
        {

            // JFormDesigner evaluation mark
            usernameChecker.setBorder(new javax.swing.border.CompoundBorder(
                new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                    "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                    javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                    java.awt.Color.red), usernameChecker.getBorder())); usernameChecker.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

            usernameChecker.setLayout(null);

            //======== panel1 ========
            {
                panel1.setBorder(new TitledBorder("Username Availability Checker"));
                panel1.setLayout(null);
                panel1.add(textField1);
                textField1.setBounds(75, 25, 115, textField1.getPreferredSize().height);

                //---- passwordField1 ----
                passwordField1.addKeyListener(new KeyAdapter() {
                    @Override
                    public void keyPressed(KeyEvent e) {
                        passwordField1KeyPressed(e);
                    }
                });
                panel1.add(passwordField1);
                passwordField1.setBounds(75, 57, 115, passwordField1.getPreferredSize().height);

                //---- button1 ----
                button1.setText("Login");
                button1.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        button1ActionPerformed(e);
                    }
                });
                panel1.add(button1);
                button1.setBounds(75, 89, 115, button1.getPreferredSize().height);

                //---- label1 ----
                label1.setText("Username");
                label1.setLabelFor(textField1);
                panel1.add(label1);
                label1.setBounds(10, 30, 65, label1.getPreferredSize().height);

                //---- label2 ----
                label2.setText("Password");
                label2.setLabelFor(passwordField1);
                panel1.add(label2);
                label2.setBounds(15, 65, 60, 16);

                //======== scrollPane1 ========
                {

                    //---- textArea1 ----
                    textArea1.setText("Separate by comma and space");
                    textArea1.setTabSize(2);
                    textArea1.setLineWrap(true);
                    textArea1.setWrapStyleWord(true);
                    textArea1.setFont(new Font("Calibri", Font.PLAIN, 12));
                    textArea1.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            textArea1MouseClicked(e);
                        }
                    });
                    textArea1.addFocusListener(new FocusAdapter() {
                        @Override
                        public void focusGained(FocusEvent e) {
                            textArea1FocusGained(e);
                        }
                        @Override
                        public void focusLost(FocusEvent e) {
                            textArea1FocusLost(e);
                        }
                    });
                    scrollPane1.setViewportView(textArea1);
                }
                panel1.add(scrollPane1);
                scrollPane1.setBounds(195, 25, 125, 90);

                //---- button2 ----
                button2.setText("Check Names");
                button2.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        button2ActionPerformed(e);
                    }
                });
                panel1.add(button2);
                button2.setBounds(195, 115, 125, button2.getPreferredSize().height);
            }
            usernameChecker.add(panel1);
            panel1.setBounds(0, 0, 330, 155);

            usernameChecker.setPreferredSize(new Dimension(330, 155));

            // Add it to the FRAME!!
            this.setContentPane(usernameChecker);
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - ryan icknem
    private JPanel usernameChecker;
    private JPanel panel1;
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JButton button1;
    private JLabel label1;
    private JLabel label2;
    private JScrollPane scrollPane1;
    private JTextArea textArea1;
    private JButton button2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                UsernameForm GUI = new UsernameForm();
                GUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                GUI.setVisible(true);
            }
        });
    }
}