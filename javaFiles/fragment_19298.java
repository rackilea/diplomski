import java.awt.Component;
import java.awt.Window;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class DisposeWindowAction extends AbstractAction {
    public DisposeWindowAction(String name, int mnemonic) {
        super(name);
        putValue(MNEMONIC_KEY, mnemonic);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Component component = (Component) e.getSource();
        if (component == null) {
            return;
        }
        Window win = SwingUtilities.getWindowAncestor(component);
        if (win == null) {
            return;
        }
        win.dispose();
    }
}