import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class MyShapesTry {

    JFrame frame = new JFrame("Deneme");

    Startthegame panelstart = new Startthegame();
    Container l;

    JLabel statusbar = new JLabel("default");

    public MyShapesTry() {

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.add(panelstart);
        frame.add(statusbar, BorderLayout.SOUTH);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }

    public static void main(String args[]) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                MyShapesTry tr = new MyShapesTry();
            }
        });
    }

}