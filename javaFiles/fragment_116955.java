public class PassWord  implements ActionListener {
    JButton b;
    JPasswordField passwd;
    PassWord() {
        JFrame f=new JFrame("Home"); 
        passwd = new JPasswordField();
        JLabel l1=new JLabel("Enter Password");  
        l1.setBounds(625,310, 150,30); 
        passwd.setBounds(600,340,150,30);
         b = new JButton("Login");
         b.setBounds(640,380,70,30);
         b.addActionListener(this); 


         f.add(passwd); f.add(l1); f.add(b);
         f.setSize(1280,720);
         f.setLayout(null);    
             f.setVisible(true);          
    }

    public void actionPerformed(ActionEvent e) {    
        char[] pass =  passwd.getPassword();
        if("test".equals(String.valueOf(pass))) {
        System.out.println("Success");
        }
     }

}