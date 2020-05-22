import javax.swing.*;
import java.awt.event.ItemEvent;

public class ComboDemo {
    public static void main(String[] args) {
        JComboBox<Product> comboBox = new JComboBox<>();
        DefaultComboBoxModel<Product> defaultComboBoxModel = new DefaultComboBoxModel<>();
        comboBox.setModel(defaultComboBoxModel);
        defaultComboBoxModel.addElement(new Product(1, "Apples"));
        defaultComboBoxModel.addElement(new Product(2, "Oranges"));

        comboBox.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                Product product = (Product) comboBox.getSelectedItem();
                System.out.println(product.getName() + " ::: " + product.getIdProduct());
            }
        });

        JOptionPane.showMessageDialog(null, comboBox);
    }
}