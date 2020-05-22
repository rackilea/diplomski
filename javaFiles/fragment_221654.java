import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.sun.accessibility.internal.resources.accessibility;

import javax.swing.JButton;

public class stas {

    private JFrame frame;
    private JTextField textField;
    private JTextField textField_1;
    public static String salary_1="";
    public static String name_1="";

    public static String []name=new String[20];
    public static String []salary=new String[20];
    public static int counter=0;
    public static void get_name(String a)
{
    name[counter]=a;


}
    public static void get_salary(String a)
{
    salary[counter]=a;


}


    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    stas window = new stas();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public stas() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblNewLabel = new JLabel("Enter Employe Name");
        lblNewLabel.setBounds(10, 47, 143, 20);
        frame.getContentPane().add(lblNewLabel);

        textField = new JTextField();
        textField.setBounds(198, 44, 86, 20);
        frame.getContentPane().add(textField);
        textField.setColumns(10);
        textField.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
        name_1=textField.getText();


            }
        });

        JLabel lblNewLabel_1 = new JLabel("Enter Employe Salary");
        lblNewLabel_1.setBounds(10, 119, 114, 17);
        frame.getContentPane().add(lblNewLabel_1);

        textField_1 = new JTextField();
        textField_1.setBounds(198, 116, 86, 20);
        frame.getContentPane().add(textField_1);
        textField_1.setColumns(10);
        textField_1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                 salary_1=textField_1.getText();



            }
        });

        JButton btnNewButton = new JButton("Add Employe");
        btnNewButton.setBounds(168, 175, 116, 23);
        frame.getContentPane().add(btnNewButton);
        btnNewButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                get_salary(salary_1);
                get_name(name_1);
                textField_1.setText("");
                textField.setText("");
                JOptionPane.showMessageDialog(null,"employe addedd");


            }
        });
       }
     }