import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

public class TransparentExample extends JFrame {

    public TransparentExample() {

        super("TransparentExample");
        Color defaultBackground = getBackground();
        float defaultOpacity = getOpacity();

        JToggleButton button1 = new JToggleButton("Toggle background transparency");
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (button1.isSelected()) {
                    setBackground(new Color(defaultBackground.getRed(), defaultBackground.getGreen(),
                            defaultBackground.getBlue(), 150));
                } else {
                    setBackground(defaultBackground);
                }
            }
        });

        JToggleButton button2 = new JToggleButton("Toggle opacity of whole frame");
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                if (button2.isSelected()) {
                    setOpacity(0.55f);
                } else {
                    setOpacity(defaultOpacity);
                }
                setVisible(true);
            }
        });

        getContentPane().setLayout(new FlowLayout());
        getContentPane().add(button1);
        getContentPane().add(button2);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame.setDefaultLookAndFeelDecorated(true);
                TransparentExample frame = new TransparentExample();
                frame.setVisible(true);
            }
        });
    }

}