import java.awt.EventQueue;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

import static javax.swing.GroupLayout.*;
import static javax.swing.GroupLayout.Alignment.*;

public class MyProject {

    private static MainForm gui = new MainForm();

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> gui.setVisible(true));
    }

    public static void clickAction() {

        gui.passText();
    }
}

class MainForm extends JFrame {

    private JTextArea jTextArea1 = new JTextArea();

    public MainForm() {

        initComponents();
    }

    private void initComponents() {

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JScrollPane jScrollPane1 = new JScrollPane();
        JButton jButton1 = new JButton();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jButton1.setText("Click me");
        jButton1.addActionListener(e -> MyProject.clickAction());

        //@formatter:off
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jScrollPane1, PREFERRED_SIZE, 318, PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
            .addGroup(TRAILING, layout.createSequentialGroup()
                .addContainerGap(DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(162, 162, 162))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jButton1)
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, PREFERRED_SIZE, 179, PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );
        //@formatter:on

        pack();
    }

    public void passText() {

        jTextArea1.append("This is a test");
    }
}