import java.awt.BorderLayout;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Ui2 extends JFrame {
    /**
     * 
     */
    private static final long serialVersionUID = 2464942276900547953L;
    private JLabel l1;
    private JPanel panel;
    private JScrollPane scrollpane;
    private JList<String> list;

    public Ui2() {
        super("HADOOP GUI");
        panel = new JPanel();
        panel.setLayout(new BorderLayout());
        setContentPane(panel);
        panel.setSize(500, 500);

        DefaultListModel<String> listmodel = new DefaultListModel<String>();
        for (int i = 1; i <= 10; i++) {
            listmodel.addElement("Record" + i);
        }

        list = new JList<String>(listmodel);
        list.setVisibleRowCount(5); // here is problem
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        scrollpane = new JScrollPane(list);

        JPanel p = new JPanel();
        p.add(scrollpane);
        panel.add(p, BorderLayout.CENTER);
        l1 = new JLabel("Default");
        panel.add(l1, BorderLayout.SOUTH);
        list.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent arg0) {

            }

        });

    }
}