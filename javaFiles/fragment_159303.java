import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;

public class Main {

    public static void main(String[] args) {
        new Main();
    }

    public Main() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                DefaultListModel<Integer> model = new DefaultListModel<>();
                for (int index = 0; index < 100; index++) {
                    model.addElement(index);
                }
                JList<Integer> list = new JList<>(model);
                list.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        deleteOrder(list.getSelectedValue());
                    }
                });
                JFrame frame = new JFrame("Testing");
                frame.add(new JScrollPane(list));
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public void deleteOrder(int id) {
        System.out.println("ID = " + id);
    }
}