import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainFrame extends JFrame implements ActionListener  
 {

   //UI Components Declaration


   JLabel EmpInfL = new JLabel("Employee Info:");
   JLabel SalDedL = new JLabel("Salary Deduction:");
   JLabel IDCL = new JLabel("ID Card");
   JLabel sayHelloLabel = new JLabel("");
   JTextField EmpInfTF = new JTextField(8);
   JTextField SalDedTF = new JTextField(9);
   JTextField IDCTF = new JTextField(8);

   JButton OkB = new JButton();
   JButton ClearB = new JButton();

   String EmployeeName
   int SalaryDeduction;
   int IDCard;

   //Constructor
   public MainFrame() {

   super("Programming Activity");
   setSize(300,100);
   setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   setVisible(true);
   setLayout(new FlowLayout());

   add(EmpInfL);
   add(EmpInfTF);


   add(SalDedL);
   add(SalDedTF);


   add(IDCL);
   add(IDCTF);
   add(sayHelloLabel);

   OkB.addActionListener(this);
   }

   public void actionPerformed(ActionEvent e)
   {
   Methods SetGet = new Methods();

   SetGet.setEmpName(EmpInfTF.getText());
   sayHelloLabel.setText("Hello, "+SetGet.getEmpName());

   }


      public static void main(String [] args)
         {

        new MainFrame();
         }
}