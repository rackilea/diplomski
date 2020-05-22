public class JTreeTest extends JPanel {

private static DefaultMutableTreeNode root;

public  static void main(String[] args) {

    JPanel panel = new JPanel(new GridLayout());
    JFrame frame = new JFrame("Test");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setContentPane(panel);
    frame.setSize(400, 400);

    root = new DefaultMutableTreeNode("A");
    DefaultTreeModel model = new DefaultTreeModel(root);
    model.insertNodeInto(new DefaultMutableTreeNode("A1"), root, 0);
    model.insertNodeInto(new DefaultMutableTreeNode("A2"), root, 0);
    model.insertNodeInto(new DefaultMutableTreeNode("A3"), root, 0);

    final JTree tree = new JTree(model);
    tree.setRootVisible(true);
    panel.add(tree);

    JButton refresh = new JButton("Refresh") ;
    panel.add(refresh);
    refresh.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(final ActionEvent e) {
            root = new DefaultMutableTreeNode("B");
            DefaultTreeModel newModel = new DefaultTreeModel(root);
            tree.setModel(newModel);
        }
    });

    frame.setVisible(true);
    }
}