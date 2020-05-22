import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.*;
public class Delete_Customer extends JFrame implements ActionListener
{
  JTextField tx1;
  JLabel l1;
 JLabel l2;
JButton b1;
Container c = getContentPane();
Delete_Customer()
{
 super("Shree Datta Digambar");
 setBounds(140,50,525,450);
 c.setLayout(null);
 tx1 = new JTextField(); 
l1 = new JLabel("Delete Customer Entry");
l2 = new JLabel("Building No");     
l1.setBounds(10,10,340,20);
l2.setBounds(10,20,140,70); 
tx1.setBounds(10,70,90,20);     
b1 = new JButton("Ok"); 
b1.setBounds(110,70,70,20);
c.add(b1);
c.add(l1);
c.add(l2);
c.add(tx1);        
setVisible(true);
setDefaultCloseOperation(EXIT_ON_CLOSE);
b1.addActionListener(this);        
}    
public void actionPerformed(ActionEvent e)
    {

        System.out.println("You clicked the button");
        if(e.getSource()==b1)
        {
            try 
            {
                Connection con;
                Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                con = DriverManager.getConnection("jdbc:odbc:Dalvi");
                try 
                {

                    java.sql.Statement st = con.createStatement();
                    PreparedStatement ps = con.prepareStatement("DELETE FROM customer_details " + " WHERE Customer_Id = ?");                            
                    ps.setString(1,tx1.getText());
                    int string = ps.executeUpdate();
                    tx1.setText("");
                    JOptionPane.showMessageDialog(null,"You Successfully Deleted The Customer");                           
                } 
                catch (SQLException s) 
                {
                    System.out.println("SQL code does not execute.");
                    JOptionPane.showMessageDialog(null,"Please Enter the Detail Correctly");   
                }
            } 
            catch (ClassNotFoundException | SQLException ee) 
            {
                System.out.println("Error:connection not created");
                JOptionPane.showMessageDialog(null,"Please Enter the Detail Correctly");
            }
        }

        }

  /*public static void main(String args[]) 
 {
  Delete_Customer dc = new Delete_Customer();
 }*/   
}