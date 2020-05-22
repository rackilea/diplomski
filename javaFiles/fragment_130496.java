import java.awt.AWTEvent;
import java.awt.Toolkit;
import java.awt.event.AWTEventListener;
import java.awt.event.HierarchyEvent;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class OptionPaneTest {

    public static void main(String[] args) {
        final AWTEventListener hierarchyListener = new AWTEventListener() {

            @Override
            public void eventDispatched(AWTEvent event) {
                final HierarchyEvent he = (HierarchyEvent) event;
                if (HierarchyEvent.HIERARCHY_CHANGED == he.getID() && he.getComponent() instanceof JOptionPane) {
                    final JDialog dlg = (JDialog) SwingUtilities.windowForComponent(he.getChangedParent());
                    if (dlg != null && !dlg.isUndecorated()) {
                        dlg.setUndecorated(true);
                    }
                }
            }
        };
        Toolkit.getDefaultToolkit().addAWTEventListener(hierarchyListener, AWTEvent.HIERARCHY_EVENT_MASK);
        JOptionPane.showMessageDialog(null, "No Border!!!");
        Toolkit.getDefaultToolkit().removeAWTEventListener(hierarchyListener);
        JOptionPane.showMessageDialog(null, "With Border!!!");
        System.exit(0);
    }
}