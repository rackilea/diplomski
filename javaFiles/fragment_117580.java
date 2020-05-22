import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class MainFrame {

    private final JTextArea textArea = new JTextArea();


    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new MainFrame();
            }
        });
    }
    public MainFrame() {
        //build gui
        final JComboBox comboBox = new JComboBox();

        comboBox.addItem("USD/TRY");
        comboBox.addItem("EUR/TRY");
        comboBox.addItem("GBP/TRY");

        JFrame f = new JFrame("Currency Converter");
        JPanel p = new JPanel(new BorderLayout());
        textArea.setName("textarea");
        textArea.setWrapStyleWord(true);
        textArea.setLineWrap(true);

        comboBox.setSelectedIndex(-1);
        comboBox.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(comboBox.getSelectedItem() + ": " + e);
            }
        });

        p.add(comboBox, BorderLayout.NORTH);
        p.add(textArea, BorderLayout.CENTER);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.pack();
        f.setSize(new Dimension(300, 300));
        f.add(p);
        f.setVisible(true);
    }
}