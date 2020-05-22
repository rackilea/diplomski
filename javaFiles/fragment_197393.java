import javax.swing.JFrame;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JPanel;

public class Demo
{
    public static void makeUI()
    {
        JFrame frame = new JFrame("Demonstration");

        /**
         * List of values for comboboxes.
         */
        List<String> list = Arrays.asList( 
            "",
            "English", 
            "French", 
            "Spanish", 
            "Japanese",
            "Chinese",
            "American English",
            "Canada French"
        );

        List<String> list2 = Arrays.asList( 
            "",
            "Anglais", 
            "Francais", 
            "Espagnol", 
            "Japonais",
            "Chinois",
            "Anglais americain",
            "Canada francais"
        );

        /**
         * Set up the frame.
         */
        JPanel panel = new JPanel();
        frame.add(panel);

        /**
         * Create ordinary comboboxes.
         * These comboboxes represent premade combobox'es. Later in the run-time we make some of them filtered.
         */
        JComboBox<String> jcb1 = new JComboBox<>(list.toArray(new String[0]));
        panel.add(jcb1);

        JComboBox<String> jcb2 = new JComboBox<>();
        panel.add(jcb2);

        JComboBox<String> jcb3 = new JComboBox<>(list2.toArray(new String[0]));
        panel.add(jcb3);

        /**
         * On the run-time we convert second and third combobox'es to filtered combobox'es.
         * The jcb1 combobox is left as it was.
         * For the first decorated combobox supply our entries.
         * For the other put entries from list2.
         */
        JComboBoxDecorator.decorate(jcb2, true, list); 
        JComboBoxDecorator.decorate(jcb3, true); 

        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void main(String[] args) throws Exception
    {
        makeUI();
    }
}