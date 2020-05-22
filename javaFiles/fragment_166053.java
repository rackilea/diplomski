import java.awt.Component;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.SwingUtilities;
import javax.swing.ToolTipManager;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;

public class TestTree {

    public enum DaysOfTheWeek {

        MONDAY("Monday", "MON", "First day of the work week."), TUESDAY("Tuesday", "TUE", "Second day of the work week");
        // etc ...

        private final String fullName;
        private final String abbrvName;
        private final String description;

        private DaysOfTheWeek(String fullName, String abbrvName, String description) {
            this.fullName = fullName;
            this.abbrvName = abbrvName;
            this.description = description;
        }

        public String getFullName() {
            return fullName;
        }

        public String getAbbrvName() {
            return abbrvName;
        }

        public String getDescription() {
            return description;
        }
    }

    public class MyTreeCellRenderer extends DefaultTreeCellRenderer {

        @Override
        public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded, boolean leaf, int row,
                boolean hasFocus) {
            Component cell = super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, hasFocus);
            if (value instanceof DefaultMutableTreeNode && ((DefaultMutableTreeNode) value).getUserObject() instanceof DaysOfTheWeek) {
                ((JLabel) cell).setText(((DaysOfTheWeek) ((DefaultMutableTreeNode) value).getUserObject()).getFullName());
            }
            return cell;
        }
    }

    private JFrame f;
    private JTree tree;

    protected void initUI() {
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Days");
        for (DaysOfTheWeek dotw : DaysOfTheWeek.values()) {
            root.add(new DefaultMutableTreeNode(dotw));
        }
        final DefaultTreeModel model = new DefaultTreeModel(root);
        tree = new JTree(model);
        tree.setRootVisible(true);
        tree.setShowsRootHandles(true);
        ToolTipManager.sharedInstance().registerComponent(tree);
        tree.setCellRenderer(new MyTreeCellRenderer());
        f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);
        f.add(new JScrollPane(tree));
        f.pack();
        f.setVisible(true);
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                new TestTree().initUI();
            }
        });
    }

}