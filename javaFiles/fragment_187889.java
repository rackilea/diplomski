import java.awt.BorderLayout;
import java.util.Enumeration;
import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeNode;

public class TreeExample2 extends JFrame {
  /****************** Developing a Simple JTree************************/
  private JTree tree;
  //private JLabel selectedLabel;  //for Event Handlers

  public TreeExample2() {
    //create the root node
    DefaultMutableTreeNode root = new DefaultMutableTreeNode("AA");
    //create the child nodes
    DefaultMutableTreeNode bb = new DefaultMutableTreeNode("BB");
    DefaultMutableTreeNode cc = new DefaultMutableTreeNode("CC");

    //add the child nodes to the root node
    root.add(bb);
    root.add(cc);

    //create the tree by passing in the root node
    tree = new JTree(root);
    add(tree);

    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setTitle("JTree Example");
    this.pack();
    this.setVisible(true);


    /****************** Adding More Children************************/
    bb.add(new DefaultMutableTreeNode("DD"));

    cc.add(new DefaultMutableTreeNode("EE"));
    cc.add(new DefaultMutableTreeNode("FF"));
    cc.add(new DefaultMutableTreeNode("GG"));

    //To get the selected node information
    tree.getSelectionModel().addTreeSelectionListener(new TreeSelectionListener() {
      @Override public void valueChanged(TreeSelectionEvent e) {
        Object o = tree.getLastSelectedPathComponent();
        if (o instanceof DefaultMutableTreeNode) {
          //TreeNode selectedNode = (TreeNode) o;
          DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) o;
          System.out.println("----");

          //children
          if (!selectedNode.isLeaf() && selectedNode.getChildCount() > 0) {
            Enumeration enumeration = selectedNode.children();
            while (enumeration.hasMoreElements()) {
              TreeNode node = (TreeNode) enumeration.nextElement();
              System.out.println("child: " + node);
            }
          } else {
            System.out.println("no children");
          }

          //sibling
          TreeNode parentNode = selectedNode.getParent();
          if (parentNode != null) {
            for (int i = 0; i < parentNode.getChildCount(); i++) {
              TreeNode node = parentNode.getChildAt(i);
              if (!selectedNode.equals(node)) {
                System.out.println("sibling: " + node);
              }
            }
          }
        }
      }
    });
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
      @Override public void run() {
        new TreeExample2();
      }
    });
  }
}