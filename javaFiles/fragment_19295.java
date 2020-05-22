import java.awt.Dialog.ModalityType;
import java.awt.Dimension;
import java.awt.event.ActionEvent;

import javax.swing.*;

public class NonModalJOptionPane {

    private static void createAndShowGui() {
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(400, 300));

        final JFrame frame = new JFrame("NonModalJOptionPane");

        panel.add(new JButton(new AbstractAction("Push Me") {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane optionPane = new JOptionPane("My Message", JOptionPane.PLAIN_MESSAGE);
                JDialog dialog = optionPane.createDialog(frame, "My Option");
                dialog.setModalityType(ModalityType.MODELESS); // **** key ***
                dialog.setVisible(true);
            }
        }));

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGui());
    }
}