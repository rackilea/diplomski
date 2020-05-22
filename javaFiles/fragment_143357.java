package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * @see http://stackoverflow.com/a/20116944/230513
 */
public class PrevNext {

    private final List<String> list = new ArrayList<>(
        Arrays.asList("Alpher", "Bethe", "Gamow", "Dirac", "Einstein"));
    private int index = list.indexOf("Einstein");
    private final JLabel label = new JLabel(list.get(index), JLabel.CENTER);

    private void display() {
        JFrame f = new JFrame("PrevNext");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(new JButton(new AbstractAction("<Prev") {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (--index < 0) {
                    index = list.size() - 1;
                }
                update();
            }
        }), BorderLayout.LINE_START);
        f.add(label);
        f.add(new JButton(new AbstractAction("Next>") {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (++index == list.size()) {
                    index = 0;
                }
                update();
            }
        }), BorderLayout.LINE_END);
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    private void update() {
        label.setText(list.get(index));
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new PrevNext().display();
            }
        });
    }
}