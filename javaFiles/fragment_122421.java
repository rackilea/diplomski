import java.awt.*;
import java.awt.datatransfer.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.*;
import java.util.List;
import javax.activation.*;
import javax.swing.*;
import javax.swing.tree.*;

public class TreeDragAndDropTest {
  private JComponent makeUI() {
    TreeTransferHandler handler = new TreeTransferHandler();
    JPanel p = new JPanel(new GridLayout(1, 2));
    p.add(new JScrollPane(makeTree(handler)));
    p.add(new JScrollPane(makeTree(handler)));
    return p;
  }

  private static JTree makeTree(TransferHandler hanlder) {
    JTree tree = new JTree();
    tree.setRootVisible(false);
    tree.setDragEnabled(true);
    tree.setTransferHandler(hanlder);
    tree.setDropMode(DropMode.INSERT);
    tree.getSelectionModel().setSelectionMode(
        TreeSelectionModel.SINGLE_TREE_SELECTION);
    expandTree(tree);
    return tree;
  }

  public static void expandTree(JTree tree) {
    for (int i = 0; i < tree.getRowCount(); i++) {
      tree.expandRow(i);
    }
  }

  public static void main(String... args) {
    EventQueue.invokeLater(() -> {
      JFrame f = new JFrame();
      f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      f.add(new TreeDragAndDropTest().makeUI());
      f.setSize(320, 240);
      f.setLocationRelativeTo(null);
      f.setVisible(true);
    });
  }
}

class TreeTransferHandler extends TransferHandler {
  private static final DataFlavor localObjectFlavor = new ActivationDataFlavor(
    DefaultMutableTreeNode[].class,
    DataFlavor.javaJVMLocalObjectMimeType,
    "Array of DefaultMutableTreeNode");
  private JTree source;

  @Override protected Transferable createTransferable(JComponent c) {
    source = (JTree) c;
    TreePath[] paths = source.getSelectionPaths();
    DefaultMutableTreeNode[] nodes = new DefaultMutableTreeNode[paths.length];
    for (int i = 0; i < paths.length; i++) {
      nodes[i] = (DefaultMutableTreeNode) paths[i].getLastPathComponent();
    }
    return new DataHandler(nodes, localObjectFlavor.getMimeType());
  }

  @Override public int getSourceActions(JComponent c) {
    return MOVE;
  }

  @Override public boolean canImport(TransferSupport support) {
    if (!support.isDrop()) {
      return false;
    }
    if (!support.isDataFlavorSupported(localObjectFlavor)) {
      return false;
    }
    JTree.DropLocation dl = (JTree.DropLocation) support.getDropLocation();
    JTree tree = (JTree) support.getComponent();
    return !tree.equals(source);
  }

  @Override public boolean importData(TransferSupport support) {
    if (!canImport(support)) {
      return false;
    }
    DefaultMutableTreeNode[] nodes = null;
    try {
      Transferable t = support.getTransferable();
      nodes = (DefaultMutableTreeNode[]) t.getTransferData(localObjectFlavor);
    } catch (UnsupportedFlavorException | IOException ex) {
      ex.printStackTrace();
    }

    JTree.DropLocation dl = (JTree.DropLocation) support.getDropLocation();
    int childIndex = dl.getChildIndex();
    TreePath dest = dl.getPath();
    DefaultMutableTreeNode parent =
      (DefaultMutableTreeNode) dest.getLastPathComponent();
    JTree tree = (JTree) support.getComponent();
    DefaultTreeModel model = (DefaultTreeModel) tree.getModel();
    int idx = childIndex < 0 ? parent.getChildCount() : childIndex;
    //DefaultTreeModel sm = (DefaultTreeModel) source.getModel();
    for (DefaultMutableTreeNode node : nodes) {
      //sm.removeNodeFromParent(node);
      //model.insertNodeInto(node, parent, idx++);

      DefaultMutableTreeNode clone = new DefaultMutableTreeNode(node.getUserObject());
      model.insertNodeInto(deepCopyTreeNode(node, clone), parent, idx++);
    }
    return true;
  }
  private static DefaultMutableTreeNode deepCopyTreeNode(
      DefaultMutableTreeNode src, DefaultMutableTreeNode tgt) {
    for (int i = 0; i < src.getChildCount(); i++) {
      DefaultMutableTreeNode node  = (DefaultMutableTreeNode) src.getChildAt(i);
      DefaultMutableTreeNode clone = new DefaultMutableTreeNode(node.getUserObject());
      tgt.add(clone);
      if (!node.isLeaf()) {
        deepCopyTreeNode(node, clone);
      }
    }
    return tgt;
  }
  @Override protected void exportDone(JComponent source, Transferable data, int action) {
    if (action == MOVE) {
      JTree tree = (JTree) source;
      DefaultTreeModel model = (DefaultTreeModel) tree.getModel();
      for (TreePath path : tree.getSelectionPaths()) {
        model.removeNodeFromParent((MutableTreeNode) path.getLastPathComponent());
      }
    }
  }
}