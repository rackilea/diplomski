import java.util.Enumeration;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

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

        TreeNode[] pathToRoot = pics.getPath();
        TreePath treePathFromPicturesToRoot = new TreePath(pathToRoot);
        System.out.println(treePathFromPicturesToRoot);

        DefaultMutableTreeNode pictureNode = (DefaultMutableTreeNode) treePathFromPicturesToRoot.getLastPathComponent();
        pictureNode.add(newFolder);

        model.nodesWereInserted(pictureNode, new int[]{pictureNode.getChildCount() - 1});

        describe(model);
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