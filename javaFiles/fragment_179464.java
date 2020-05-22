import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class Test {

    public Test() {

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JTextField f1 = new JTextField(10);

        JTextField f2 = new JTextField(10);

        //f2.requestFocusInWindow(); //wont work (if uncomment this remember to comment the one after setVisible or you wont see the reults)

        JButton b = new JButton("Button");

        JPanel p = new JPanel();

        p.add(f1);//by default first added component will have focus
        p.add(f2);
        p.add(b);

        frame.add(p);

        //f2.requestFocusInWindow();//wont work
        frame.pack();//Realize the components.
        //f2.requestFocusInWindow();//will work
        frame.setVisible(true);

        f2.requestFocusInWindow();//will work
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {//if we remove this block it wont work also (no matter when we call requestFocusInWindow)
            @Override
            public void run() {
                new Test();
            }
        });
    }
}