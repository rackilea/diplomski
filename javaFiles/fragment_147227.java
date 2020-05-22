class a extends JFrame implements ActionListener
{
JTextField t1,t2,t3;
a()
{

    setLayout(null);
    t1 = new JTextField();
    t2 = new JTextField();
    t3 = new JTextField();
    JButton B1 = new JButton("Calculate");

    t3.setEditable(false);

    t1.setBounds(10,10,100,30);
    t2.setBounds(10,40,100,30);
    t3.setBounds(10,70,100,30);

    B1.setBounds(50, 110, 80, 50);

    add(t1);
    add(t2);
    add(t3);
    add(B1);

    B1.addActionListener(this);

    setSize(200,200);
    setVisible(true);
}
public static void main(String args[])
    {
        new a();
    }
@Override
public void actionPerformed(ActionEvent e) 
{
    double Snumber = Double.parseDouble(t1.getText());
    double Rnumber = Double.parseDouble(t2.getText());
    double Anumber = Snumber+Rnumber;
    t3.setText(String.valueOf(Anumber));

}