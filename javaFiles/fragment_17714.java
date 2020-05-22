import com.mysql.jdbc.Statement;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;

public class Userdialog {

  static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
  static final String DB_URL      = "jdbc:mysql://localhost/mydb";
  static final String USER        = "root";
  static final String PASS        = "";

  Connection conn = null;
  Statement  st   = null;

  JTextField name;
  JButton    proceed;

  public Userdialog()
  {
    JFrame useradd = new JFrame("Add user to database");
    useradd.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    name = new JTextField(10);
    useradd.setLayout(new GridLayout(0, 1));
    JPanel pane = new JPanel(new GridLayout(0, 1));
    useradd.add(pane);
    pane.add(new JLabel("First name: "));
    pane.add(name);
    proceed = new JButton("Add that user");
    pane.add(proceed);
    proceed.addActionListener(new ActionListener()
    {
      @Override
      public void actionPerformed(ActionEvent e)
      {
        //HOW TO MAKE IT TO THE SQL TABLE???
        try
        {
          Class.forName("com.mysql.jdbc.Driver");
          conn= DriverManager.getConnection(DB_URL, USER, PASS);
          st = (Statement) conn.createStatement();
          st.execute("insert into user (name) values('"+name.getText()+"')");
          JOptionPane.showMessageDialog(null, "Inserted Successfully!");
        }
        catch(Exception ex)
        {
          ex.printStackTrace();
        }
      }});
    useradd.pack();
    useradd.setSize(300,200);
    useradd.setVisible(true);
  }

  public static void main(String[] args)
  {
    new Userdialog();
  }
}