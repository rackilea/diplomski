import javax.swing.*;
import java.awt.*;

public class HighlightMenu extends JMenu {

    private Font bold_large = new Font("Helvetica", Font.BOLD, 26);

    private Color bgColor = Color.getHSBColor(0f, 0f, 60/360f);
    private Color highlighted = Color.getHSBColor(0f, 0f, 110/360f);

    HighlightMenu(String str) {
        setText(str);
        setPreferredSize(new Dimension(100, 40));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                setBackground(Color.GREEN);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                setBackground(UIManager.getColor("control"));
            }
        });
        setOpaque(true);
        setFont(bold_large);
    }
}