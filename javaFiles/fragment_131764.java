import javax.swing.*; 
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.Container;

public class L63GUIApp extends JFrame
{
    JPanel panelTop = new JPanel();
    JButton butLogin = new JButton("LogIn password");
    JComboBox cBoxTT;
    JTable tableInfo;
    JScrollPane scrollP;
    JLabel labelStatus = new JLabel();

    String [] cBoxList = {"Create", "User", "LoginRecord", "About Us"};
    String [] sHeader = {"Student ID", "Name", "Programme", "Weight", "Super Ability"};
    String [] tHeader = {"Teacher ID", "Name"};
    String [][] sRecords = { // for simplicity, we use direct String information
            {"00000000","Andy LAU","AENG","100.00"},
            {"21212122","Betty CHOW","HDIT","50.50","GREAT Sleeping Skill"},
            {"21212123","Candy AU","HDIS","60.50","GREAT Programming Skill"}
        };

    String [][] tRecords = { // for simplicity, we use direct String information
            {"T222","AU A.B.","xyz"},
            {"T223","CHAN C.D.","abc"}
        };

    L63GUIApp()
    { // constructor
        setTitle ( "Student Teacher Record System" );
        setSize ( 800,500 );
        setDefaultCloseOperation ( EXIT_ON_CLOSE );
        initGUI();
    }

    void initGUI()
    { // method to initialize/setup GUI (layout, components, etc.)
        cBoxTT = new JComboBox(cBoxList);
        cBoxTT.setSelectedIndex(0);
        panelTop.add(butLogin); //add button to top JPanel
        panelTop.add(cBoxTT); //add combo box to top JPanel
        cBoxTT.setEnabled(false);

        butLogin.addActionListener( new ActionListener() 
        { //add action to button
            public void actionPerformed(ActionEvent event) 
            {
                loginCheck();
            } 
        });

        cBoxTT.addActionListener( new ActionListener() 
        { //add action to combo box
            public void actionPerformed(ActionEvent event)
            {
                updateSelectedTable();
            } 
        });

        add(panelTop, BorderLayout.NORTH);
        add(labelStatus, BorderLayout.SOUTH);
    }

    void loginCheck()
    {
        String loginName = JOptionPane.showInputDialog(null,"What is your Login Name?");
        if (loginName==null) JOptionPane.showMessageDialog(null, "NULL Name??");
        else if (loginName.equals("a"))
        { // use "a" as login password, as admin.
            JOptionPane.showMessageDialog(null, "RIGHT Login Name: " + loginName);
            cBoxTT.setEnabled(true);
            butLogin.setEnabled(false);
            setTitle ( "Student Teacher Record System - Login: " + loginName);
        }
        else if (loginName.equals("g"))
        {
            JOptionPane.showMessageDialog(null, "RIGHT Login Name: " + loginName);
            cBoxTT.setEnabled(true);
            butLogin.setEnabled(false);
            setTitle ( "Student Teacher Record System - Login: " + loginName);
        }
        else JOptionPane.showMessageDialog(null, "WRONG Login Name: "+ loginName);
    }

    void updateSelectedTable()
    {

          Container c=getContentPane(); 

          //this you have do befor adding new compoment 
          c.remove(1);

        System.out.println("index:"+cBoxTT.getSelectedIndex());
        if (scrollP!=null) this.remove(scrollP);
        if (cBoxTT.getSelectedIndex()==0)
            {tableInfo = new JTable(new DefaultTableModel(sRecords, sHeader));
        }
        if (cBoxTT.getSelectedIndex()==1)
            {tableInfo = new JTable(new DefaultTableModel(tRecords, tHeader));
        }
        if (cBoxTT.getSelectedIndex()==2)
            {tableInfo = new JTable(new DefaultTableModel(sRecords, sHeader));
        }            
        if (cBoxTT.getSelectedIndex()==3)
            {
            AboutUs();
        }        
            add(scrollP = new JScrollPane(tableInfo), BorderLayout.CENTER);
            labelStatus.setText("Information of " + cBoxList[cBoxTT.getSelectedIndex()]);
            setVisible(false); setVisible(true);
    }

    void AboutUs()
    {

        setTitle("About Us: G07, CL02, 2019-2020, OOP");    
        setSize(800,500);    
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    
        JLabel t=new JLabel("<html>Members:<br>John<br>Rebecca<br>Harry<br>Mila<br>Kelvin</html>");    
        Container c=getContentPane(); 

        ImageIcon img = new ImageIcon("???.jpg");
        t.setIcon(img);
        c.add(t);   
        setVisible(true);    
      //   new AboutUs();
    }

    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable() 
        { // for thread concurrency issue

            public void run() 
            {
                new L63GUIApp().setVisible(true);
            }
        });

        System.out.println("END of software system");
        }
}