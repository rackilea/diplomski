package test;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Test {

    public static void main(String[] args) {
        JPanel p = new JPanel(new BorderLayout(5, 5));

        JPanel labels = new JPanel(new BorderLayout());
        labels.add(new JLabel("Name", SwingConstants.RIGHT),BorderLayout.NORTH);
        labels.add(new JLabel("Description", SwingConstants.RIGHT), BorderLayout.CENTER);
        p.add(labels, BorderLayout.WEST);

        JPanel controls = new JPanel(new BorderLayout());
        JTextField name = new JTextField();
        controls.add(name, BorderLayout.NORTH);
        JTextArea description = new JTextArea();
        JScrollPane sp = new JScrollPane(description);
        // description.addAncestorListener(new RequestFocusListener(false));
        sp.setPreferredSize(new Dimension(400, 100));
        controls.add(sp, BorderLayout.CENTER);
        p.add(controls, BorderLayout.CENTER);

        JOptionPane.showConfirmDialog(null, p, "Create Atomic Action", JOptionPane.OK_CANCEL_OPTION);
    }
}