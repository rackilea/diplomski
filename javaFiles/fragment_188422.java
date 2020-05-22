import java.awt.BorderLayout;
import java.util.Properties;
import java.util.Set;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.SwingUtilities;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;


public class GetAllProperties extends JFrame {

    private static final String NOTHING_SELECTED = "<nothing selected>";

    private final JScrollPane treeScroll;
    private final JTree tree;
    private final DefaultTreeModel treeModel;
    private final DefaultMutableTreeNode root;
    private final JLabel descriptionLabel;

    private Properties properties;

    public GetAllProperties() {
        setLayout(new BorderLayout());

        root = new DefaultMutableTreeNode("GIT commands");
        treeModel = new DefaultTreeModel(root);
        tree = new JTree(treeModel);
        treeScroll = new JScrollPane(tree);
        add(treeScroll, BorderLayout.WEST);

        populateTree();        

        descriptionLabel = new JLabel(NOTHING_SELECTED);
        add(descriptionLabel, BorderLayout.CENTER);

        tree.addTreeSelectionListener(new TreeSelectionListener() {

            public void valueChanged(TreeSelectionEvent e) {
                DefaultMutableTreeNode selection = 
                        (DefaultMutableTreeNode)tree.getLastSelectedPathComponent();
                if (selection != null) {
                    String key = (String)selection.getUserObject();
                    String command = properties.getProperty(key);
                    descriptionLabel.setText(command);
                } else {
                    descriptionLabel.setText(NOTHING_SELECTED);
                }
            }
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            public void run() {
                new GetAllProperties().setVisible(true);
            }
        });
    }

    private void populateTree() {
        // fake properties in order to avoid IO
        properties = new Properties();
        properties.setProperty("foo1", "bar1");
        properties.setProperty("foo2", "bar2");
        properties.setProperty("foo3", "bar3");
        properties.setProperty("foo4", "bar4");

        Set<Object> keySet = properties.keySet();
        for (Object key : keySet) {
            root.add(new DefaultMutableTreeNode(key));
        }

        tree.expandPath(new TreePath(root));
    }

}