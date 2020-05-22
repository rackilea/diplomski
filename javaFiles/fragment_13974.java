import java.awt.event.*;
import javax.swing.*;

public class SwingDemo extends JFrame {

    private JLabel filozof1;
    private JTextArea rezultat;
    private JTextField textField;
    private JButton but;

    public SwingDemo() {
        super("Filozofi chinezi");
        start();
    }

    public void start() {
        setLayout(null);
        JLabel label = new JLabel("Numar folozofi :");
        label.setBounds(20, 20, 100, 20);
        add(label);
        filozof1 = new JLabel();
        filozof1.setBounds(124, 50, 100, 20);
        rezultat = new JTextArea();
        rezultat.setBounds(50, 200, 700, 400);
        rezultat.setLineWrap(true);
        textField = new JTextField(2);
        textField.setBounds(124, 20, 100, 20);

        but = new JButton("Start");
        but.setBounds(280, 20, 70, 20);

        but.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 1; i <= Integer.parseInt(textField.getText()); i++) {
                    rezultat.append(i + ". line\n");
                    // or
                    JLabel label = new JLabel(i + ". label");
                    label.setBounds(20 + (i * 25), 20 + (i * 25), 100, 20);
                    add(label);
                }
                revalidate();
                repaint();
            }
        });

        add(filozof1);
        add(rezultat);
        add(textField);
        add(but);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                JFrame frame = new SwingDemo();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setSize(800, 700);
                frame.setVisible(true);
            }
        });
    }
}