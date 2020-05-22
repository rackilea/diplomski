import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class PanelFix extends JFrame {
    JFrame frame = this;
    private JPanel view = a();

    PanelFix() {
        super("Panel Fix");
        setSize(400, 400);
        setLocationRelativeTo(null);
        getContentPane().add(view);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private JPanel a() {
        JPanel panel = new JPanel();
        JButton but = new JButton("Press Me");
        but.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                getContentPane().remove(view);
                view = b();
                getContentPane().add(view);
                repaint();
                validate();
            }
        });
        panel.add(but);
        return panel;
    }

    private JPanel b() {
        JPanel panel = new JPanel();
        panel.add(new JLabel("Second Panel"));
        return panel;
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> new PanelFix());
    }
}