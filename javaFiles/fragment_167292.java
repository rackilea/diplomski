public class CafeView extends JFrame{

private JButton takeMoneyBtn = new JButton("Hesabı Al");

public CafeView(){
    JPanel table1 = new JPanel();
    this.setSize(800,600);
    this.setLocation(600, 200);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setVisible(true);

   //table1.setBounds(100, 100, 150, 150);
    //table1.setLayout(null);
    this.add(table1,BorderLayout.CENTER);
    table1.add(takeMoneyBtn);

}