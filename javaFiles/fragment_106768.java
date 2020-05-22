import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;

public class SelectableTree extends JFrame implements TreeSelectionListener {

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new SelectableTree();
            }
        });
    }
    DefaultMutableTreeNode root;
    DefaultMutableTreeNode e1 = new DefaultMutableTreeNode("1");
    DefaultMutableTreeNode e2 = new DefaultMutableTreeNode("2");
    DefaultMutableTreeNode e3 = new DefaultMutableTreeNode("3");
    DefaultMutableTreeNode e11 = new DefaultMutableTreeNode("1.1");
    DefaultMutableTreeNode e22 = new DefaultMutableTreeNode("2.2");
    DefaultMutableTreeNode e33 = new DefaultMutableTreeNode("3.3");
    DefaultMutableTreeNode e111 = new DefaultMutableTreeNode("1.1.1");
    DefaultMutableTreeNode e222 = new DefaultMutableTreeNode("2.2.2");
    DefaultMutableTreeNode e333 = new DefaultMutableTreeNode("3.3.3");
    DefaultMutableTreeNode aChild;
    private JTree tree;
    private JTextField currentSelectionField;

    public SelectableTree() {
        super("JTree Selections");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        root = new DefaultMutableTreeNode("Root");
        root.add(e1);
        root.add(e2);
        root.add(e3);
        e1.add(e11);
        e2.add(e22);
        e3.add(e33);
        e11.add(e111);
        e22.add(e222);
        e33.add(e333);

        tree = new JTree(root);
        tree.addTreeSelectionListener(this);
        add(new JScrollPane(tree), BorderLayout.CENTER);
        currentSelectionField = new JTextField("Current Selection: NONE");
        add(currentSelectionField, BorderLayout.SOUTH);
        setSize(250, 275);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void valueChanged(TreeSelectionEvent event) {
        tree.expandPath(new TreePath(e11.getPath()));
        currentSelectionField.setText(event.getPath().toString());
    }
}