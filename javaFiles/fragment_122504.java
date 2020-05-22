import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.TimerTask;
import javax.swing.*;

public class JavaApplication180 extends JFrame {

    private JTextField[] JTextFields;
    private JMenuBar menuBar;
    private JMenu menu;
    private JMenuItem item;

    public JavaApplication180() {
        initComponents();

        createAndShowUI();
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new JavaApplication180();
            }
        });
    }

    private void createAndShowUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(new GridLayout(2, 2, 10, 10));
        setJMenuBar(menuBar);
        addComponentsToPane();

        pack();
        setVisible(true);
    }

    private void initComponents() {
        JTextFields = new JTextField[4];

        menuBar = new JMenuBar();
        item = new JMenuItem("Who has focus?");
        item.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                TimerTask tt = new TimerTask() {

                    @Override
                    public void run() {
                        JOptionPane.showMessageDialog(null, getMostRecentFocusOwner().getName());
                    }
                };
                new java.util.Timer().schedule(tt, 100);
            }
        });

        menu = new JMenu("File");
        menu.add(item);
        menuBar.add(menu);
    }

    private void addComponentsToPane() {
        for (int i = 0; i < JTextFields.length; i++) {
            JTextFields[i] = new JTextField();
            JTextFields[i].setText(String.valueOf(i));
            JTextFields[i].setName(String.valueOf(i));
            getContentPane().add(JTextFields[i]);
        }
    }
}