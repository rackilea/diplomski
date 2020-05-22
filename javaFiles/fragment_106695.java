import java.awt.Dimension;
import javax.swing.*;

public class TestCombo extends JPanel {
    private static final Product[] products = {
            new Product("One", 1.0),
            new Product("Two", 2.0),
            new Product("Three", 3.0),
            new Product("Four", 4.0),
            new Product("Five", 5.0),
    };

    private DefaultComboBoxModel<ItemCombo> comboModel = new DefaultComboBoxModel<>();
    private JComboBox<ItemCombo> itemsComboBox = new JComboBox<>(comboModel);

    public TestCombo() {
        add(itemsComboBox);
        for (Product product : products) {
            comboModel.addElement(new ItemCombo(product));
        }
        itemsComboBox.addActionListener(e -> {
            ItemCombo itemCombo = (ItemCombo) itemsComboBox.getSelectedItem();
            System.out.println("Selection: " + itemCombo.getProduct());
        });

        setPreferredSize(new Dimension(400, 150));
    }

    private static void createAndShowGui() {
        JFrame frame = new JFrame("TestCombo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new TestCombo());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGui());
    }
}


class ItemCombo {

    private Product product;

    public ItemCombo(Product p) {
        this.product = p;
    }

    @Override
    public String toString(){
        return product.getName();
    }

    public double getPrice() {
        return product.getPrice();
    }   

    public Product getProduct() {
        return product;
    }
}

class Product {

    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Product [name=" + name + ", price=" + price + "]";
    }
}