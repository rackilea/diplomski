import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.tree.*;

public class TreeNodeRenameExample extends JFrame {

    private JPanel  contentPane;
    private JTree tree;

    private AliasTreeNode peterNode = new AliasTreeNode(new TestObj("Peter"),
                                                        "Alias 1");
    private AliasTreeNode stephenNode = new AliasTreeNode(new TestObj("Stephen"),
                                                          "Alias 2");

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    TreeNodeRenameExample frame = new TreeNodeRenameExample();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public TreeNodeRenameExample() {
        initGUI();
    }
    private void initGUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        this.contentPane = new JPanel();
        this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        this.contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(this.contentPane);
        {
            this.tree = new JTree();
            this.tree.setModel(new DefaultTreeModel(
                    new DefaultMutableTreeNode("JTree") {
                        {
                            add(peterNode);
                            add(stephenNode);
                        }
                    }
            ));
            this.contentPane.add(this.tree, BorderLayout.CENTER);

            JButton changeNamesButton = new JButton("Change node names");
            this.contentPane.add(changeNamesButton, BorderLayout.SOUTH);
            changeNamesButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    peterNode.setAlias("MyTreeNode1");
                    stephenNode.setAlias("MyTreeNode2");
                }
            });
        }
    }


    public class TestObj {
        private String name;

        public TestObj(String name) {
            this.name = name;
        }

        public String toString() {
            return "Name: " + this.name;
        }
    }


    public class AliasTreeNode extends DefaultMutableTreeNode {
        private String alias;

        public AliasTreeNode(Object userObject, String alias) {
            super(userObject);
            this.alias = alias;
        }

        public void setAlias(String alias) {
            this.alias = alias;

            // Notify the tree model of the changed node
            // (see http://stackoverflow.com/a/10375802/1694043).
            ((DefaultTreeModel) tree.getModel()).nodeChanged(this);
        }

        @Override
        public String toString() {
            return (alias != null) ? alias : super.toString();
        }
    }
}