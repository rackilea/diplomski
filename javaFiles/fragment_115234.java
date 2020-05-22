import javax.swing.AbstractListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

public class SimpleListExample implements Runnable {


    public static void main(String[] args) {
        SwingUtilities.invokeLater(new SimpleListExample());
    }

    @Override
    public void run() {
        JList<String> list = new JList<>(new SimpleListModel());
        JFrame frame = new JFrame("List example");
        frame.add(new JScrollPane(list));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(350, 200);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    @SuppressWarnings("serial")
    private static class SimpleListModel extends AbstractListModel<String> {

        @Override
        public int getSize() {
            return 20;
        }

        @Override
        public String getElementAt(int index) {
            // Generate constant value with the row index ;)
            return "It's row number: " + (index + 1);
        }
    }
}