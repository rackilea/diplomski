import java.awt.EventQueue;
import java.awt.GridLayout;
import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.LookAndFeel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.metal.MetalLookAndFeel;

/** @see https://stackoverflow.com/a/14262706/230513 */
public class JTreePanel extends JPanel {

    public static final class Icons {

        private static final String COLLAPSED_ICON = "Tree.collapsedIcon";
        private static final String EXPANDED_ICON = "Tree.expandedIcon";
        private Icon collapsed;
        private Icon expanded;

        public static Icons getDefault() {
            Icons icons = new Icons();
            icons.collapsed = (Icon) UIManager.get(COLLAPSED_ICON);
            icons.expanded = (Icon) UIManager.get(EXPANDED_ICON);
            return new Icons();
        }

        public static Icons getMetal() {
            Icons icons = new Icons();
            try {
                LookAndFeel save = UIManager.getLookAndFeel();
                LookAndFeel laf = new MetalLookAndFeel();
                UIManager.setLookAndFeel(laf);
                icons.collapsed = (Icon) UIManager.get(COLLAPSED_ICON);
                icons.expanded = (Icon) UIManager.get(EXPANDED_ICON);
                UIManager.setLookAndFeel(save);
            } catch (UnsupportedLookAndFeelException ex) {
                ex.printStackTrace(System.err);
            }
            return icons;
        }
    }

    public JTreePanel(Icons pair) {
        UIManager.put("Tree.collapsedIcon", pair.collapsed);
        UIManager.put("Tree.expandedIcon", pair.expanded);
        JTree tree = new JTree();
        this.add(tree);
        for (int i = 0; i < tree.getRowCount(); i++) {
            tree.expandRow(i);
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                createGUI();
            }
        });
    }

    private static void createGUI() {
        final JFrame frame = new JFrame();
        frame.setLayout(new GridLayout(1, 0));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new JTreePanel(Icons.getDefault()));
        frame.add(new JTreePanel(Icons.getMetal()));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}