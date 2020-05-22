import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;

public class JListExample extends JFrame {

    private JPanel p1, p2;
    private JList jList;
    private JScrollPane scrollPane;
    private JTextField jtfChoice;

    public JListExample() // constructor
    {
        String[] itemList = {"alpla", "beta", "gamma", "delta", "omega"};
        jList = new JList(itemList);
        jList.setSelectedIndex(1);
        jList.setVisibleRowCount(3);
        jList.setSize(220, 200);

        p1 = new JPanel();
        p1.add(jtfChoice = new JTextField(8), BorderLayout.CENTER);

        p2 = new JPanel();
        p2.add(scrollPane = new JScrollPane(jList), BorderLayout.WEST);
        p2.add(p1);

        add(p2, BorderLayout.EAST);
        ListenerClass listener = new ListenerClass();
        jList.addListSelectionListener(listener);
    }

    public static void main(String[] args) {
        JListExample frame = new JListExample();
        frame.setTitle("JList Example");
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private class ListenerClass implements ListSelectionListener {

        public void valueChanged(ListSelectionEvent e) {
            jtfChoice.setText(jList.getSelectedValue().toString());
        }
    }
}