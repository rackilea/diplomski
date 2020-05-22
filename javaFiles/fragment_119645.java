import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Example {

    public static void main(String[] args){
        JFrame frame = new JFrame();

        final JPanel panel = new JPanel(new CardLayout());

        JLabel l1 = new JLabel("1");
        JLabel l2 = new JLabel("2");
        JLabel l3 = new JLabel("3");

        panel.add(l1,"l1");
        panel.add(l2,"l2");
        panel.add(l3,"l3");

        JButton btn = new JButton("next");
        btn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                CardLayout layout = (CardLayout) panel.getLayout();
                layout.next(panel);
            }
        });

        JButton btnSpec = new JButton("l3");
        btnSpec.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                CardLayout layout = (CardLayout) panel.getLayout();
                layout.show(panel, "l3");
            }
        });

        frame.add(panel);
        frame.add(btn,BorderLayout.SOUTH);
        frame.add(btnSpec,BorderLayout.NORTH);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

}