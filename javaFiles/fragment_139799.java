import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;


public class TestFrame extends JFrame {

    public TestFrame() {
        init();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void init() {
        JTable t = new JTable(3,3);
        add(new JScrollPane(t));
        JPanel btns = new JPanel(new FlowLayout(FlowLayout.LEFT,0,0));
        JButton jButton = new JButton("here");
        btns.add(jButton);
        add(btns,BorderLayout.SOUTH);
    }


    public static void main(String args[]) {
        new TestFrame();
    }

}