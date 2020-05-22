import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class Mail {

    protected void initUI() {
        JFrame frame = new JFrame("New Message");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel list = new JPanel(new GridBagLayout());
        frame.add(list, BorderLayout.CENTER);
        GridBagConstraints labelGBC = new GridBagConstraints();
        labelGBC.insets = new Insets(3, 3, 3, 3); // Put some space between elements for nicer look
        labelGBC.anchor = GridBagConstraints.WEST; // Align left within its cell
        GridBagConstraints fieldGBC = new GridBagConstraints();
        fieldGBC.gridwidth = GridBagConstraints.REMAINDER; // Last element of the row
        fieldGBC.weightx = 1.0; // Cell takes up all extra horizontal space
        fieldGBC.fill = GridBagConstraints.HORIZONTAL; // Fill the cell horizontally
        fieldGBC.insets = new Insets(3, 3, 3, 3); // Put some space between elements for nicer look
        String[] labels = { "To: ", "Cc: ", "Bcc: ", "Subject: " };
        for (int i = 0; i < labels.length; i++) {
            JLabel l = new JLabel(labels[i]);
            JTextField f = new JTextField(50);
            list.add(l, labelGBC);
            list.add(f, fieldGBC);
        }
        GridBagConstraints taGBC = new GridBagConstraints();
        taGBC.gridwidth = 2;
        taGBC.weightx = 1.0; // Cell takes up all extra horizontal space
        taGBC.weighty = 1.0; // Cell takes up all extra vertical space
        taGBC.fill = GridBagConstraints.BOTH; // Fill cell in both direction
        taGBC.insets = new Insets(3, 3, 3, 3); // Put some space between elements for nicer look
        JTextArea textArea = new JTextArea(10, 80);
        list.add(new JScrollPane(textArea), taGBC);

        frame.pack();

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Mail().initUI();
            }
        });

    }
}