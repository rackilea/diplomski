import java.awt.FlowLayout;
import java.io.FileNotFoundException;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class ComboBox extends JFrame {

    public ComboBox() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(300, 300);
        setLocationRelativeTo(null);
        getContentPane().setLayout(new FlowLayout());
        Integer[] numbers = { 4, 5, 8, 123, 42, 634 };
        JComboBox<Integer> comboBox = new JComboBox<>(numbers);
        comboBox.setSelectedItem(42); // The initial selection is 42.
        comboBox.addActionListener(e -> {
            int selectedNumber = (int) comboBox.getSelectedItem();
            System.out.println("Selected number: " + selectedNumber);
            // Do whatever with selected number
        });
        add(comboBox);
    }

    public static void main(String[] args) throws FileNotFoundException {
        SwingUtilities.invokeLater(() -> new ComboBox().setVisible(true));
    }

}