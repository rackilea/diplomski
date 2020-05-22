import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class Login extends JFrame{

   //public JFrame frame; //Extends JFrame already so 'this' IS a frame
   public JPasswordField passwordField;
   public JTextField textField;
   public JButton blogin;
   public JButton btnNewUser;

   /**
    * Launch the application.
    */
   public static void main(String[] args) {
       EventQueue.invokeLater(new Runnable() {
           public void run() {
               try {
                   Login window = new Login();
                   window.setVisible(true);
               } catch (Exception e) {
                   e.printStackTrace();
               }
           }
       });
   }

   /**
    * Create the application.
    */
   public Login() {
       initialize();
   }

   /**
    * Initialize the contents of the frame.
    */
   public void initialize() {

     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //DO NOT forget this, the instance will continue to run if not.
     setLayout(null);

     setSize(350,300); // only added so I didn't have to expand window as often

     passwordField = new JPasswordField();
     passwordField.setBounds(90, 114, 105, 22);
     add(passwordField);

     textField = new JTextField();
     textField.setBounds(90, 79, 105, 22);
     add(textField);
     textField.setColumns(10);

     JLabel lblUsername = new JLabel("Username");
     lblUsername.setBounds(220, 82, 76, 16);
     add(lblUsername);

     JLabel lblPassword = new JLabel("Password");
     lblPassword.setBounds(220, 117, 66, 16);
     add(lblPassword);

     JButton blogin = new JButton("Login");
     blogin.setBounds(144, 158, 97, 25);
     blogin.addActionListener(new ActionListener() { //moved from actionlogin()
         public void actionPerformed(ActionEvent ae){
            actionlogin();
         }
     });

     add(blogin);

     JButton btnNewUser = new JButton("New User ?");
     btnNewUser.setBounds(144, 196, 97, 25);
     add(btnNewUser);        

     add(blogin);
     add(passwordField);
     add(textField);
   }

   //Logincode lc = new Logincode(); Don't know why the second class was created or needed here.

   public void actionlogin(){

        //Scanner sc; not used
        Scanner scan=null;

        try {
            //sc = new Scanner(new File("Logincode.txt")); not used 
            scan = new Scanner(new File("Change to the path where your file is located ofcourse")); //make sure to add your path

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        //Scanner keyboard = new Scanner (System.in);       

        //String inpUser = keyboard.nextLine();
        String inpUser;
        inpUser = textField.getText();

        //String inpPass = keyboard.nextLine();
        String inpPass;
        inpPass = passwordField.getText();// gets input from user

        String user="";
        if(scan.hasNextLine()) //added to check if there is another line to read
           user = scan.nextLine();            

        String pass="";
        if(scan.hasNextLine())
           pass = scan.nextLine(); // looks at selected file in scan

            if (inpUser.equals(user)&& inpPass.equals(pass)){
                System.out.print("your login message");
            }else {
                JOptionPane.showMessageDialog(null,"Wrong Password / Username");
            }
   }       

}