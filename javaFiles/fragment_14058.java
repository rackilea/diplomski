import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;

public class MainWindow1 extends JFrame implements ItemListener {

    public MainWindow1() {

        String[] petStrings = { "Bird", "Cat", "Dog", "Rabbit", "Pig" };

        //Create the combo box, select item at index 4.
        //Indices start at 0, so 4 specifies the pig.

        setLayout(new FlowLayout());

        JComboBox petList1 = new JComboBox(petStrings);
        //petList1.setSelectedIndex(4);
        petList1.addItemListener(this);
        petList1.setName("petList1");

        JComboBox petList2 = new JComboBox(petStrings);
        petList2.setSelectedIndex(4);
        petList2.addItemListener(this);
        petList2.setName("petList2");

        JComboBox petList3 = new JComboBox(petStrings);
        petList3.setSelectedIndex(4);
        petList3.addItemListener(this);
        petList3.setName("petList3");

        getContentPane().add(petList1);
        getContentPane().add(petList2);
        getContentPane().add(petList3);


        setSize(800, 600);
        setVisible(true);
    }

    public static void main(String[] args) {
        new MainWindow1();

    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e != null && e.getSource().toString() != null && e.getSource().toString().contains("petList1") && e.getStateChange() == ItemEvent.SELECTED) {

            System.out.println( "1" + e.getSource());
        } else if (e != null && e.getSource().toString() != null && e.getSource().toString().contains("petList2") && e.getStateChange() == ItemEvent.SELECTED) {
            System.out.println( "2" + e.getSource());
        } else if (e != null && e.getSource().toString() != null && e.getSource().toString().contains("petList3") && e.getStateChange() == ItemEvent.SELECTED) {

            System.out.println("3" + e.getSource());
        }

    }

}