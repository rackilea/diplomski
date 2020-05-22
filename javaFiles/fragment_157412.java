import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Interface {

    private JLabel label;
    private JLabel label2;
    private JLabel label3;
    private JTextField textfield;
    private JTextField textfield2;
    private JTextField textfield3;
    private JButton button;
    private JButton button2;
    private JButton button3;
    private JPanel panel;

    public static void main(String[] args) {
        new Interface();
    }

    public Interface() {
        JFrame frame = new JFrame("Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);

        JPanel buttonPane = new JPanel();
        label = new JLabel("Button 1");
        label2 = new JLabel("Button 2");
        label3 = new JLabel("Button 3");

        textfield = new JTextField(5);

        JButton button = new JButton("cirkel");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.removeAll();
                panel.add(label);
                panel.add(textfield);
                panel.revalidate();
                panel.repaint();
                String text = textfield.getText();

                // Van de String 'text' een double maken
                double diameter = Double.parseDouble(text);

//      cirkel C1 = new cirkel();
//      C1.setDiam(diameter);
                label.setText("De diameter = " + 1 + " cm \n\n");
                label.setText("De straal = " + 2 + " cm");
                label.setText("De oppervlakte van de cirkel = " + 3 + " cm2");
            }
        });

        JButton button2 = new JButton("driehoek");
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.removeAll();
                panel.add(label);
                panel.add(textfield);
                panel.revalidate();
                panel.repaint();
                // driehoek
            }
        });

        JButton button3 = new JButton("vierhoek");
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.removeAll();
                panel.add(label);
                panel.add(textfield);
                panel.revalidate();
                panel.repaint();
                // vierhoek
            }
        });

        buttonPane.add(button);
        buttonPane.add(button2);
        buttonPane.add(button3);

        panel = new JPanel();

        frame.add(buttonPane, BorderLayout.NORTH);
        frame.add(panel);
        frame.setVisible(true);
    }
}