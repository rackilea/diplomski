import java.awt.*;
import javax.swing.*;

public class MainForm {

    protected  JFrame window = new JFrame("Test Form");
    protected  JButton btnOK = new JButton("OK!");

    public static void main(String st[]) {
        SwingUtilities.invokeLater( new Runnable()
        {
            public void run()
            {
                MainForm mf = new MainForm();
                mf.load();
            }
        });

    }
    public void load() {
    Container c = window.getContentPane();
    c.setLayout(new FlowLayout());//Set layout to be FlowLayout explicitly.
    btnOK.setPreferredSize(new Dimension(100,50));//use set PreferredSize
    c.add(btnOK);
    c.setSize(500, 500);
    c.setVisible(true);
    }

}