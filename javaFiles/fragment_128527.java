import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

public class TreeExample implements Runnable {

    private static final Object NODES[][] =
            {{1, "color", null}, {2, "red", 1}, {3, "white", 1}, {4, "green", 1}, {5, "dark", 4}, {6, "light", 4}};

    @Override
    public void run() {
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Root");
        // use while loop to make you easer to switch to your result set.
        int index = 0;
        Map<Integer, DefaultMutableTreeNode> nodesMap = new HashMap<>();
        while (index < NODES.length) {
            Integer id = getValue(NODES[index], 0, Integer.class);
            Integer parentId = getValue(NODES[index], 2, Integer.class);
            String name = getValue(NODES[index], 1, String.class);
            DefaultMutableTreeNode node = new DefaultMutableTreeNode(name);
            nodesMap.put(id, node);
            if (parentId == null) {
                root.add(node);
            } else {
                nodesMap.get(parentId).add(node);
            }
            index++;
        }
        JTree tree = new JTree(new DefaultTreeModel(root));
        expandTree(tree);
        JFrame frm = new JFrame("Tree test");
        frm.add(new JScrollPane(tree));
        frm.setSize(300, 200);
        frm.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frm.setLocationRelativeTo(null);
        frm.setVisible(true);
    }

    private <T> T getValue(Object[] array, int index, Class<T> clazz) {
        return clazz.cast(array[index]);
    }

    private void expandTree(JTree tree) {
        int row = 0;
        while (tree.getRowCount() > row) {
            tree.expandRow(row++);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new TreeExample());
    }
}