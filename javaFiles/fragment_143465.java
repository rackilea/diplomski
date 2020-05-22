import java.awt.*;
import java.awt.image.*;
import javax.swing.*;

public class Popup extends JDialog {

    public Popup() {
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.insets = new Insets(5, 5, 5, 5);

        JLabel header = new JLabel("Hai ricevuto una nuova email");
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridheight = 1;
        gbc.weightx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        add(header, gbc);

        gbc.weightx = 0;
        JLabel mittente = new JLabel("luca.cillario@yahoo.itabcditabcditabcditabcditabcd");
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridheight = 1;
        add(mittente, gbc);

        JLabel argomento = new JLabel("info voto esame");
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridheight = 1;
        add(argomento, gbc);

        JLabel icona = new JLabel(new ImageIcon(
                new BufferedImage(40,60,BufferedImage.TYPE_INT_RGB)));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridheight = 3;
        gbc.fill = GridBagConstraints.BOTH;
        add(icona, gbc);

        this.setLocation(400, 400);
        this.setUndecorated(true);
        pack();
        super.setSize(260, 100);
        this.setVisible(true);
        mittente.setMaximumSize(new Dimension(180, 16));
    }

    public static void main(String args[]) {
        new Popup();
    }
}