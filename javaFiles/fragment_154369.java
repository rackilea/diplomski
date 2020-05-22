import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JFrame;
public class Combobox extends JFrame{
Combobox(){
    this.setVisible(true);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    String[] list={"car","bus","bike"};
    final JComboBox c1=new JComboBox(list);
    final JComboBox c2=new JComboBox(list);
    Container c=this.getContentPane();
    c.setLayout(new FlowLayout());
    c.add(c1);
    c.add(c2);
    c1.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
            int index=c1.getSelectedIndex();
            c2.removeItemAt(index);
            }
    });
    this.pack();
}
    public static void main(String[] args) {
        new Combobox();
    }
}