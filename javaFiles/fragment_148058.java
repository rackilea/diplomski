import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Foo extends JFrame {

    public Foo() {
        jLabel1 = new JLabel("label 1");
        jPanel1 = new JPanel();
        jPanel1.add(jLabel1);
        add(jPanel1);
        pack();
        // code to update whatever you like here
        doThings();
    }

    private void doThings() {
        // code to update whatever you like here
        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                jLabel1.setText("foo " + (j++));
            }
        };
        Timer timer = new Timer(500, actionListener);
        timer.start();
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Foo().setVisible(true);
            }
        });
    }
    private JLabel jLabel1;
    private JPanel jPanel1;
    private int j = 0;
}