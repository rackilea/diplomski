import java.awt.*;
import javax.swing.*;

public class TilesWithButton {

    private Icon warningIcon = UIManager.getIcon("OptionPane.warningIcon");
    private Icon infoIcon = UIManager.getIcon("OptionPane.informationIcon");
    private Icon errorIconRoll = UIManager.getIcon("OptionPane.errorIcon");
    private JPanel myPanel = new JPanel();

    public TilesWithButton() {
        myPanel.setLayout(new GridLayout(1, 2, 1, 1));

        JButton btn = new JButton();
        btn.setBackground(Color.white);
        btn.setIcon(infoIcon);
        btn.setRolloverIcon(errorIconRoll);
        btn.setFocusPainted(false);
        myPanel.add(btn);

        JButton btn1 = new JButton();
        btn1.setBackground(Color.white);
        btn1.setIcon(warningIcon);
        btn1.setRolloverIcon(errorIconRoll);
        btn1.setFocusPainted(false);
        myPanel.add(btn1);

        JFrame frame = new JFrame("Tiles");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(myPanel);
        frame.pack();
        frame.setLocation(150, 100);
        frame.setVisible(true);
    }

    public static void main(final String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                TilesWithButton tilesWithButton = new TilesWithButton();
            }
        });
    }
}