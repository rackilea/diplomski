import java.awt.BorderLayout;
import java.util.List;
import javax.swing.*;

class MultiSelectListInOptionPane {

    public static void main(String[] args) {
        Runnable r = new Runnable() {

            @Override
            public void run() {
                JPanel gui = new JPanel(new BorderLayout());

                String[] fruit = {"Apple", "Banana", "Grapefruit", "Orange"};
                JList<String> list = new JList<String>(fruit);
                gui.add(new JScrollPane(list));

                JOptionPane.showMessageDialog(
                        null, 
                        gui,
                        "Rekening",
                        JOptionPane.QUESTION_MESSAGE);
                List items = (List)list.getSelectedValuesList();
                for (Object item : items) {
                    System.out.println("Selected: " + item);
                }
            }
        };
        // Swing GUIs should be created and updated on the EDT
        // http://docs.oracle.com/javase/tutorial/uiswing/concurrency
        SwingUtilities.invokeLater(r);
    }
}