import java.awt.Component;
import java.awt.Graphics;

import javax.swing.Icon;


public class DoubleIcon implements Icon {

    private static final int ICONSPACING = 4;

    private final Icon i1;
    private final Icon i2;

    public DoubleIcon(Icon i1, Icon i2) {
        this.i1 = i1;
        this.i2 = i2;
    }

    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
        i1.paintIcon(c, g, x, y + (getIconHeight() - i1.getIconHeight()) / 2);
        i2.paintIcon(c, g, x + ICONSPACING + i1.getIconWidth(), y + (getIconHeight() - i2.getIconHeight()) / 2);
    }

    @Override
    public int getIconWidth() {
        return i1.getIconWidth() + ICONSPACING + i2.getIconWidth();
    }

    @Override
    public int getIconHeight() {
        return Math.max(i1.getIconHeight(), i2.getIconHeight());
    }
}