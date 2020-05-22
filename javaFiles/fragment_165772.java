import java.util.Arrays;
import java.util.Enumeration;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;

public class Test {

    public static void main(String[] args) {
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("~");
        DefaultTreeModel model = new DefaultTreeModel(root);

        DefaultMutableTreeNode docs = new DefaultMutableTreeNode("Documents");
        docs.add(new DefaultMutableTreeNode("text1.txt"));
        docs.add(new DefaultMutableTreeNode("text2.txt"));
        root.add(docs);

        DefaultMutableTreeNode pics = new DefaultMutableTreeNode("Pictures");
        pics.add(new DefaultMutableTreeNode("text1.txt"));
        root.add(pics);

        describe(model);

        DefaultMutableTreeNode newFolder = new DefaultMutableTreeNode("folder1");
        newFolder.add(new DefaultMutableTreeNode("text1.txt"));

        insertNodes(model, findNode(model, "~/Pictures"), newFolder);

        describe(model);
    }

    protected static DefaultMutableTreeNode findNode(DefaultTreeModel model, String path) {
        DefaultMutableTreeNode node = (DefaultMutableTreeNode) model.getRoot();
        String[] parts = path.split("/");
        if (node.getUserObject().toString().equals(parts[0])) {
            return findNode(node, Arrays.copyOfRange(parts, 1, parts.length));
        }
        return null;
    }

    protected static DefaultMutableTreeNode findNode(DefaultMutableTreeNode node, String[] path) {
        if (path.length == 0) {
            return node;
        }
        Enumeration<TreeNode> children = node.children();
        while (children.hasMoreElements()) {
            DefaultMutableTreeNode child = (DefaultMutableTreeNode) children.nextElement();
            if (child.getUserObject().toString().equals(path[0])) {
                return findNode(child, Arrays.copyOfRange(path, 1, path.length));
            }
        }
        return null;
    }

    private static void insertNodes(
            DefaultTreeModel model,
            DefaultMutableTreeNode parent,
            DefaultMutableTreeNode newNode) {

        parent.add(newNode);
        model.nodesWereInserted(parent, new int[]{parent.getChildCount() - 1});
    }

    protected static void describe(DefaultTreeModel model) {
        describe((DefaultMutableTreeNode) model.getRoot(), 0);
    }

    protected static void describe(DefaultMutableTreeNode node, int level) {
        StringBuilder padding = new StringBuilder();
        for (int index = 0; index < level; index++) {
            padding.append("  ");
        }
        System.out.println(padding + "+ " + node);
        padding.append("  ");
        Enumeration<TreeNode> children = node.children();
        while (children.hasMoreElements()) {
            DefaultMutableTreeNode childNode = (DefaultMutableTreeNode) children.nextElement();
            if (childNode.isLeaf()) {
                System.out.println(padding + "- " + childNode);
            } else {
                describe(childNode, level + 1);
            }
        }
    }
}