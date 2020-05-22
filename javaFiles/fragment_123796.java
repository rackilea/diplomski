import java.awt.CardLayout;

import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class ML extends JFrame {
    private static final long serialVersionUID = 1L;

    public ML() {
        GridLayout gl = new GridLayout(1, 2);
        setLayout(gl);

        JPanel jp = new JPanel();
        CardLayout cl = new CardLayout();
        jp.setLayout(cl);

        JPanel jp1 = new JPanel();
        JLabel jl = new JLabel("Enter mouse!");
        jp1.add(jl);

        JPanel jp2 = new JPanel();
        JTextField jtf = new JTextField(20);
        jp2.add(jtf);

        jp.add(jp1, "1");
        jp.add(jp2, "2");
        cl.show(jp, "1");

        jl.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                cl.show(jp, "2");
            }
        });

        jtf.addMouseListener(new MouseAdapter() {
            public void mouseExited(MouseEvent evt) {
                cl.show(jp, "1");
            }
        });

        add(jp);

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.pack();
        this.setVisible(true);

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ML();
            }
        });
    }
}