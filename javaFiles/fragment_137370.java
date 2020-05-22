import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.LayoutManager;

public class StackLayout implements LayoutManager {

    @Override
    public void layoutContainer(Container parent) {
        Insets insets = parent.getInsets();
        int maxWidth = parent.getWidth() - (insets.left + insets.right);

        int y = insets.top;

        for(int n = 0; n < parent.getComponentCount(); n++) {
            Component c = parent.getComponent(n);
            int height = c.getPreferredSize().height;
            c.setBounds(0, y, maxWidth, height);

            y += height;
        }
    }

    @Override
    public Dimension minimumLayoutSize(Container c) {
        int sumHeight = 0;
        int maxWidth = 0;

        for(int n = 0; n < c.getComponentCount(); n++) {
            Dimension preferredSize = c.getComponent(n).getPreferredSize();
            if(n == 0) {
                maxWidth = preferredSize.width;
            } else {
                maxWidth += preferredSize.width;
            }
            sumHeight += preferredSize.height;
        }

        // add the containers insets
        Insets insets = c.getInsets();
        sumHeight += insets.top + insets.bottom;
        maxWidth += insets.left + insets.right;

        return new Dimension(maxWidth, sumHeight);
    }

    @Override
    public Dimension preferredLayoutSize(Container c) {
        return minimumLayoutSize(c);
    }

    @Override
    public void addLayoutComponent(String arg0, Component c) {}

    @Override
    public void removeLayoutComponent(Component c) {}

}