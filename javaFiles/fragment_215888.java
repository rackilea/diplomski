public class MyJPanel extends JPanel { 
    public myJPanel(){           
        super();

        JButton j1 = new JButton("Button1");
        JButton j2 = new JButton("Button2");

        //Notice the order of parameters here (Local for one is remote for the other)
        MyJPanel1 p1 = new MyJPanel1(j1, j2);
        MyJPanel2 p2 = new MyJPanel2(j2, j1);

        setBackground(Color.gray);      
        setLayout(new BorderLayout());

        add(p1,"North");    
        add(p2,"Center");                               
    }
}