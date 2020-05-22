import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ColorClick {

    public static void main(String[] args) {
        final JPanel panel = new JPanel(new GridBagLayout()) {
            {
                setBackground(Color.RED);
            }
            @Override
            public Dimension getPreferredSize() {
                return new Dimension(200, 200);
            }
        };
        JButton button = new JButton("Change Color");
        button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                if (panel.getBackground() == Color.RED) {
                    System.out.println("RED");
                    panel.setBackground(Color.GREEN);
                } else if (panel.getBackground() == Color.GREEN) {
                    System.out.println("GREEN");
                    panel.setBackground(Color.RED);
                }
            }
        });
        panel.add(button);
        JOptionPane.showMessageDialog(null, panel);
    }
}