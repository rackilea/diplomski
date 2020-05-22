import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class TestFrame extends JFrame {

    private JList<Integer> normal;
    private JList<Integer> fail;
    private Integer[] vals;

    public TestFrame() {
        init();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void init() {
        normal = new JList<Integer>(new DefaultListModel<Integer>());
        fail = new JList<Integer>(new DefaultListModel<Integer>());

        vals = new Integer[]{1,2,3,4,5,6,7,8,9,33};
        JButton add = new JButton("collect data");
        add.addActionListener(getCollectListener());
        JButton clear = new JButton("clear data");
        clear.addActionListener(getClearListener());

        JPanel p = new JPanel();
        p.add(new JScrollPane(normal));
        p.add(new JScrollPane(fail));

        JPanel btnPanel = new JPanel();
        btnPanel.add(add);
        btnPanel.add(clear);
        add(p);
        add(btnPanel,BorderLayout.SOUTH);
    }

    private ActionListener getClearListener() {
        return new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                ((DefaultListModel<Integer>)normal.getModel()).removeAllElements();
                ((DefaultListModel<Integer>)fail.getModel()).removeAllElements();
            }
        };
    }

    private ActionListener getCollectListener() {
        return new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                for(Integer i : vals){
                    if(i%3==0){
                        ((DefaultListModel<Integer>)normal.getModel()).addElement(i);
                    } else {
                        ((DefaultListModel<Integer>)fail.getModel()).addElement(i);
                    }
                }
            }
        };
    }

    public static void main(String args[]) {
        new TestFrame();
    }

}