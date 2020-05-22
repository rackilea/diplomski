import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Test extends JPanel implements ItemListener {
    private JComboBox comboBox;
    private JList list;

    public Test() {
        comboBox = new JComboBox();
        list = new JList(new DefaultListModel());

        /* initialize combo box */
        loadComboBox();

        /* listen for combo box selections */
        comboBox.addItemListener(this);

        /* simple layout */
        setLayout(new BorderLayout());
        add(comboBox, BorderLayout.NORTH);
        add(new JScrollPane(list), BorderLayout.CENTER);
    }

    /**
     * Invoked when an item has been selected or deselected by the user.
     */
    public void itemStateChanged(ItemEvent e) {
        if (e.getStateChange() == ItemEvent.SELECTED) {
            /* add item to list */
            ((DefaultListModel) list.getModel()).addElement(e.getItem());
        }
    }

    private void loadComboBox() {
        /* let's fake some content here */
        Object[] objects = { "foo", "bar", "baz", "qux",
                             "quux", "corge", "grault",
                             "garply", "waldo", "fred",
                             "plugh", "xyzzy", "thud" };

        /* put the objects into the combo box */
        comboBox.setModel(new DefaultComboBoxModel(objects));
    }

    public static void main(String[] args) {
        Test test = new Test();

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(test);

        frame.setSize(300, 400);

        frame.setVisible(true);
    }
}