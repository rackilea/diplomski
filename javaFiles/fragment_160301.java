import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class SimpleClass extends JFrame {
    public SimpleClass(String title) {
        super(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout());
        setUp();
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public SimpleClass() {

    }

    public void setUp() {
        JPanel panel = new JPanel();

        ExtendedClass e = new ExtendedClass();
        SimpleClass s = new ExtendedClass();
        SimpleClass thisInstance = this;

        JButton button = new JButton("Press Me");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                System.out.println(e instanceof ExtendedClass);
                e.printLn();

                System.out.println(s instanceof ExtendedClass);
                ((ExtendedClass)s).printLn();

                System.out.println(thisInstance instanceof ExtendedClass);
                //Returns an exception as it is not an instance of ExtendedClass
                ((ExtendedClass)thisInstance).printLn();
            }
        });

        panel.add(button);
        getContentPane().add(panel);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> new SimpleClass("Title"));
    }
}