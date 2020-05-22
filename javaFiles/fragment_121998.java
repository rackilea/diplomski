import java.awt.*;
import java.net.*;
import javax.swing.*;
import javax.swing.tree.*;

public class TestTree extends JDialog {

    JTree tree;

    DefaultTreeModel treeModel;

    public TestTree() {
        setSize(300, 800);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        System.out.println(getContentPane().getBackground());
    }

    protected static ImageIcon createImageIcon(String path) throws MalformedURLException {
        java.net.URL imgURL = new URL(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }

    public void init() throws MalformedURLException {
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Numbers");
        treeModel = new DefaultTreeModel(root);
        tree = new JTree(treeModel);
        tree.setBackground(new Color(238, 238, 244));
        tree.setOpaque(true);

        CustomIconRenderer customIconRenderer = new CustomIconRenderer();
        customIconRenderer.setTextSelectionColor(Color.white);
        customIconRenderer.setBackgroundSelectionColor(Color.blue);
        customIconRenderer.setBorderSelectionColor(Color.black);
        customIconRenderer.setBackgroundNonSelectionColor(new Color(238, 238,
                244));
        ImageIcon icon = createImageIcon("http://i.stack.imgur.com/wCF8S.png");
        customIconRenderer.setLeafIcon(icon);
        tree.setCellRenderer(new CustomIconRenderer());

        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0) {
                DefaultMutableTreeNode subroot = new DefaultMutableTreeNode(
                        "node_" + i);
                root.add(subroot);

                if (i % 3 == 0) {
                    for (int j = 10; j < 15; j++) {
                        DefaultMutableTreeNode leaf = new DefaultMutableTreeNode(
                                "node_" + j);
                        subroot.add(leaf);
                    }
                }
            } else {
                DefaultMutableTreeNode subroot = new DefaultMutableTreeNode(
                        "node_" + i);
                root.add(subroot);
                if (i % 4 == 0) {
                    for (int j = 15; j < 20; j++) {
                        DefaultMutableTreeNode leaf = new DefaultMutableTreeNode(
                                "node_" + j);
                        subroot.add(leaf);
                    }
                }
            }
        }

        for (int i = 0; i < tree.getRowCount(); i++) {
            tree.expandRow(i);
        }

        tree.setCellRenderer(customIconRenderer);

        getContentPane().add(tree, BorderLayout.CENTER);
    }

    public static void main(String args[]) throws MalformedURLException {
        TestTree tt = new TestTree();
        tt.init();
        tt.setVisible(true);
    }
}

class CustomIconRenderer extends DefaultTreeCellRenderer {

    /**
     *
     */
    private static final long serialVersionUID = 967937360839244309L;
    ImageIcon groupedIcon;
    ImageIcon unGroupedIcon;

    public CustomIconRenderer() throws MalformedURLException {
        URL url = new URL("http://i.stack.imgur.com/wCF8S.png");
        URL url1 = new URL("http://i.stack.imgur.com/T5uTa.png");
        groupedIcon = new ImageIcon(url1);
        unGroupedIcon = new ImageIcon(url);
    }

    @Override
    public Component getTreeCellRendererComponent(JTree tree, Object value,
            boolean sel, boolean expanded, boolean leaf, int row,
            boolean hasFocus) {

        super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf,
                row, hasFocus);

        Object nodeObj = ((DefaultMutableTreeNode) value).getUserObject();
        String s = nodeObj.toString();
        System.out.println("s: " + s);
        boolean includesUnderscore = s.indexOf("_") > 0;
        if (includesUnderscore) {
            String lastPart = s.split("_")[1];
            int num = Integer.parseInt(lastPart);
            // check whatever you need to on the node user object
            if (num % 2 == 0) {
                setIcon(unGroupedIcon);
            } else {
                System.out.println("reached");
                setIcon(groupedIcon);
            }
        }
        return this;
    }
}