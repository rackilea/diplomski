import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

public class ComboItemTest {
   public static void main(String[] args) {
      DefaultComboBoxModel<MyComboItem> comboModel = 
              new DefaultComboBoxModel<MyComboItem>();

      // note that here you would fill the model with data from your database ***
      comboModel.addElement(new MyComboItem("x1234A", "Product 1"));
      comboModel.addElement(new MyComboItem("x1235A", "Product 2"));
      comboModel.addElement(new MyComboItem("x1236A", "Product 3"));
      comboModel.addElement(new MyComboItem("x1237A", "Product 4"));
      comboModel.addElement(new MyComboItem("x1238A", "Product 5"));
      comboModel.addElement(new MyComboItem("x1239A", "Product 6"));

      final JComboBox<MyComboItem> combobox = new JComboBox<MyComboItem>(comboModel);

      combobox.addActionListener(new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent e) {
            MyComboItem item = (MyComboItem) combobox.getSelectedItem();
            if (item != null) {
               System.out.printf("You've selected Product Name: %s, Product ID: %s%n", 
                     item.getProductName(), item.getProductId());
            }
         }
      });

      JOptionPane.showMessageDialog(null, new JScrollPane(combobox));

   }
}