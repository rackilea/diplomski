import java.awt.BorderLayout;
    import java.awt.event.ActionEvent;
    import java.awt.event.ActionListener;
    import java.util.ArrayList;
    import java.util.Enumeration;
    import java.util.List;

    import javax.swing.JButton;
    import javax.swing.JFrame;
    import javax.swing.JScrollPane;
    import javax.swing.JTree;
    import javax.swing.tree.DefaultMutableTreeNode;
    import javax.swing.tree.DefaultTreeModel;
    import javax.swing.tree.TreePath;

    public class TreeDemo extends JFrame implements ActionListener{
        private static final long serialVersionUID = 1L;
        public JTree tree;
        public JButton button;

        public TreeDemo() {

            button = new JButton("Find Queen");


            button.addActionListener(this);

            tree = new JTree();
            DefaultMutableTreeNode root = new DefaultMutableTreeNode( "Deck" );
            DefaultMutableTreeNode itemClubs= new DefaultMutableTreeNode( "Clubs" );
            addAllCard( itemClubs );
            root.add( itemClubs );

            DefaultMutableTreeNode itemDiamonds = new DefaultMutableTreeNode( "Diamonds" );
            addAllCard( itemDiamonds );
            root.add( itemDiamonds );

            DefaultMutableTreeNode itemSpades = new DefaultMutableTreeNode( "Spades" );
            addAllCard( itemSpades );
            root.add( itemSpades );

            DefaultMutableTreeNode itemHearts = new DefaultMutableTreeNode( "Hearts" );
            addAllCard( itemHearts );
            root.add( itemHearts );

            DefaultTreeModel treeModel = new DefaultTreeModel( root );
            tree = new JTree( treeModel );

            JScrollPane scrollPane = new JScrollPane(tree);
            getContentPane().add(scrollPane, BorderLayout.CENTER);
            getContentPane().add(button, BorderLayout.NORTH);

            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setSize(375, 400);      
        }

        public void addAllCard( DefaultMutableTreeNode suit ) {
            suit.add( new DefaultMutableTreeNode( "Ace" ) );
            suit.add( new DefaultMutableTreeNode( "Two" ) );
            suit.add( new DefaultMutableTreeNode( "Three" ) );
            suit.add( new DefaultMutableTreeNode( "Four" ) );
            suit.add( new DefaultMutableTreeNode( "Five" ) );
            suit.add( new DefaultMutableTreeNode( "Six" ) );
            suit.add( new DefaultMutableTreeNode( "Seven" ) );
            suit.add( new DefaultMutableTreeNode( "Eight" ) );
            suit.add( new DefaultMutableTreeNode( "Nine" ) );
            suit.add( new DefaultMutableTreeNode( "Ten" ) );
            suit.add( new DefaultMutableTreeNode( "Jack" ) );
            suit.add( new DefaultMutableTreeNode( "Queen" ) );
            suit.add( new DefaultMutableTreeNode( "King" ) );
        }

        public final DefaultMutableTreeNode findNode(String searchString) {

            List<DefaultMutableTreeNode> searchNodes = getSearchNodes((DefaultMutableTreeNode)tree.getModel().getRoot());
            DefaultMutableTreeNode currentNode = (DefaultMutableTreeNode)tree.getLastSelectedPathComponent();

            DefaultMutableTreeNode foundNode = null;
            int bookmark = -1;

            if( currentNode != null ) {
                for(int index = 0; index < searchNodes.size(); index++) {
                    if( searchNodes.get(index) == currentNode ) {
                        bookmark = index;
                        break;
                    }
                }
            }

            for(int index = bookmark + 1; index < searchNodes.size(); index++) {    
                if(searchNodes.get(index).toString().toLowerCase().contains(searchString.toLowerCase())) {
                    foundNode = searchNodes.get(index);
                    break;
                }
            }

            if( foundNode == null ) {
                for(int index = 0; index <= bookmark; index++) {    
                    if(searchNodes.get(index).toString().toLowerCase().contains(searchString.toLowerCase())) {
                        foundNode = searchNodes.get(index);
                        break;
                    }
                }
            }
            return foundNode;
        }   

        private final List<DefaultMutableTreeNode> getSearchNodes(DefaultMutableTreeNode root) {
            List<DefaultMutableTreeNode> searchNodes = new ArrayList<DefaultMutableTreeNode>();

            Enumeration<?> e = root.preorderEnumeration();
            while(e.hasMoreElements()) {
                searchNodes.add((DefaultMutableTreeNode)e.nextElement());
            }
            return searchNodes;
        }

        public static void main(String[] args) {
            TreeDemo app = new TreeDemo();
            app.setVisible(true);


        }


        public void actionPerformed(ActionEvent e) {
            DefaultMutableTreeNode node = findNode("Queen");                
            if( node != null ) {
                TreePath path = new TreePath(node.getPath());
                tree.setSelectionPath(path);
                tree.scrollPathToVisible(path);
            }       
        }
    }