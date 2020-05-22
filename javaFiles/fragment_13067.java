public class Demo {
static JTextField txtName;
static JButton jbSubmit;
public Demo()
{
    txtName = new JTextField(10);
    jbSubmit = new JButton("Submit");
    jbSubmit.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
            change("XYZ");
            }
    });

}
public static void change(String name)
{
    txtName.setText(name);
}

public static void main(String[] args) {
    Demo d = new Demo();

    JFrame jf=new JFrame();
    jf.add(txtName);
    jf.add(jbSubmit);
    jf.setLayout(new FlowLayout());
    jf.setVisible(true);
    jf.setSize(500,200);

}