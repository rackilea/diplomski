import java.awt.BorderLayout;
import java.awt.Container;
import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class TestFile2 {

    private static JList list1;
    private static JList list2;

    public static void main(String args[]) {
        String size[] = {"Small", "Medium", "Large", "Extra Large"};
        String toppings[] = {"Cheese", "Pepperoni", "Sausage", "Spinach", "Pepperoncini"};
        JFrame f = new JFrame("Pizza");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        list1 = new JList(size);
        list2 = new JList(toppings);
        Container c = f.getContentPane();
        JScrollPane sp1 = new JScrollPane(list1);
        sp1.setColumnHeaderView(new JLabel("Select Size"));
        JScrollPane sp2 = new JScrollPane(list2);
        sp2.setColumnHeaderView(new JLabel("Select Toppings. Hold Ctrl to select multiple toppings"));
        Box box = Box.createHorizontalBox();
        box.add(sp1);
        box.add(sp2);
        list1.addListSelectionListener(new ListSelectionListener() 
        {

            public void valueChanged(ListSelectionEvent e)
            {
                handleEvent(e);
            }
        });
        list2.addListSelectionListener(new ListSelectionListener() 
        {

            public void valueChanged(ListSelectionEvent e)
            {
                handleEvent(e);
            }
        });
        c.add(box, BorderLayout.CENTER);
        f.setSize(
                300, 200);
        f.setVisible(
                true);
    }

    protected static void handleEvent(ListSelectionEvent e) 
    {

        double cost = 0.0;
         Object[] selection = list1.getSelectedValues();
         Object[] toppings = list2.getSelectedValues();

         if(toppings.length == 0)
             System.out.println("Please select a topping");

         if(selection.length == 0)
             System.out.println("Please select a size");

         if (!e.getValueIsAdjusting()) 
         {
             System.out.println("----");
             for (int i = 0; i < selection.length; i++) 
             {
                 double costSize;
                 if (selection[i].equals("Small")) {
                    cost = 7.00;
                 } else if (selection[i].equals("Medium")) {
                    cost = 9.00;
                 } else if (selection[i].equals("Large")) {
                    cost = 11.00;
                 } else {
                    cost = 14.00;
                 }

             }


             for (int i = 0; i < toppings.length; i++) 
             {
                cost++;
             }


             System.out.println("Total = " + cost);
         }

    }
}