import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JComboBox;
import javax.swing.JFrame;

public class DemoFrame {

private JFrame frame;
private JComboBox comboBox;
private String[] items = {"IT1","IT2","IT3"};

public DemoFrame() {
    frame = new JFrame("Demo Frame");
    frame.setSize(300, 300);
    comboBox = new JComboBox(items);
    comboBox.addItemListener(new ItemListener() {
        @Override
        public void itemStateChanged(ItemEvent e) {
            //perform here your database querys for specific items.

            if(e.getItem().equals(items[0]) && e.getStateChange() == ItemEvent.SELECTED) {
                //db query for it "IT1"
            }
        }

    });

    frame.add(comboBox);
    frame.setVisible(true);

}

public static void main(String[] args) {
    java.awt.EventQueue.invokeLater(new Runnable() {
        @Override
        public void run() {
            new DemoFrame();
        }
    });
}

}