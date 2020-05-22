import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class FontInOptionPane {

    FontInOptionPane() {
        JLabel l = new JLabel();
        Font f = l.getFont();
        l.setText(f.toString());

        JOptionPane.showMessageDialog(null, l);

        f = f.deriveFont(Font.ITALIC);
        l.setText(f.toString());
        l.setFont(f);
        JOptionPane.showMessageDialog(null, l);

        f = f.deriveFont(50f);
        l.setText(f.toString());
        l.setFont(f);
        JOptionPane.showMessageDialog(null, l);
    }

    public static void main(String[] args) {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                new FontInOptionPane();
            }
        };
        SwingUtilities.invokeLater(r);
    }
}