import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JComponent;

public class myComponent extends JComponent {
    private static final long serialVersionUID = 1L;

    public myComponent() {
        // setPreferredSize(new Dimension(20,50)); Don't call this here!
        setToolTipText(new String("This is a custom buttion"));
    }

    @Override
    public Dimension getPreferredSize() {
        if (super.isPreferredSizeSet()) {
            return super.getPreferredSize();
        }
        return new Dimension(220,220); // or (20,50), just as you want...
    }

    ...
}