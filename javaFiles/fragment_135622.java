package CustomComponents;

import java.awt.Container;
import java.awt.Dimension;

public class CSize {
    public static void setDefiniteSize(Container c, int h, int w) {
        Dimension k = new Dimension (h, w);
        c.setMaximumSize(k);
        c.setMinimumSize(k);
        c.setPreferredSize(k);
    }
}