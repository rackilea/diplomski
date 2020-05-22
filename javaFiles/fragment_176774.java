JFrame frame = new JFrame("Test");
frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
DefaultMutableTreeNode root = new DefaultMutableTreeNode("Root");
DefaultTreeModel model = new DefaultTreeModel(root);
final JTree tree = new JTree(model);

//flyweight pattern components
//editor
final JComboBox editorComboBox = new JComboBox();
final JComboBox viewComboBox = new JComboBox();
final Box box = Box.createHorizontalBox();
final JLabel myLabel = new JLabel();
myLabel.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 10));
box.add(myLabel);
box.add(Box.createHorizontalGlue());
box.add(viewComboBox);
//Custom Renderer
DefaultTreeCellRenderer renderer = new DefaultTreeCellRenderer (){
    @Override
    public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded, boolean leaf, int row, boolean hasFocus) {
        super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, hasFocus);
        if ( leaf ){
            if ( value instanceof MyLeafNode ){
                MyLeafNode node = (MyLeafNode)value;
                viewComboBox.removeAllItems();
                myLabel.setText(value.toString());
                for ( String item : node.items ){
                    viewComboBox.addItem(item);
                }
                viewComboBox.setSelectedItem(node.selected);
                return box;
            }
        }
        return this;
    }
};

//Custom Editor
final DefaultTreeCellEditor editor = new DefaultTreeCellEditor(tree, renderer){

    final ActionListener actionListener = new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
            cancelCellEditing();
            tree.repaint();
        }
    };

    @Override
    public boolean isCellEditable(EventObject e){
        if ( e.getSource() instanceof JTree ){
            JTree tree = (JTree)e.getSource();
            if ( tree.getLastSelectedPathComponent() == null ){
                return false;
            }
            DefaultMutableTreeNode o = (DefaultMutableTreeNode)tree.getLastSelectedPathComponent();
            return o.isLeaf();
        }
        return false;
    }

    @Override
    public void cancelCellEditing(){
        super.cancelCellEditing();
        DefaultMutableTreeNode node = (DefaultMutableTreeNode)tree.getLastSelectedPathComponent();
        if ( node instanceof MyLeafNode) {
            String sel = editorComboBox.getSelectedItem().toString();
            MyLeafNode mln = (MyLeafNode)node;
            mln.selected = sel;
            editorComboBox.removeActionListener(actionListener);
            tree.repaint();
        }
    }

    @Override
    public Component getTreeCellEditorComponent(JTree tree, Object value, boolean isSelected, boolean expanded, boolean leaf, int row) {
        if ( leaf ){
            if ( tree.getLastSelectedPathComponent() instanceof MyLeafNode ){
                MyLeafNode o = (MyLeafNode)tree.getLastSelectedPathComponent();
                editorComboBox.removeAllItems();
                for ( String item : o.items ){
                    editorComboBox.addItem(item);
                }
                editorComboBox.setSelectedItem(o.selected);
                editorComboBox.addActionListener(actionListener);
            }
            return editorComboBox;

        }
        return super.getTreeCellEditorComponent(tree, value, isSelected, expanded, leaf, row);
    }

};
tree.setCellRenderer(renderer);
TreePath path = new TreePath(new TreeNode[]{root});
tree.expandPath(path);

for ( int i = 0; i < 2; i++ ){
    DefaultMutableTreeNode p = new DefaultMutableTreeNode("P" + i);
    model.insertNodeInto(p, root, i);
    for ( int j = 0; j < 2; j++ ){
        String[] items = {"Item 1", "Item 2", "Item 3", "Item 4"};
        MyLeafNode n = new MyLeafNode("N" + j, items);
        model.insertNodeInto(n, p, j);
    }
    path = new TreePath(new TreeNode[]{root, p});
    tree.expandPath(path);
}
tree.setCellEditor(editor);
tree.setEditable(true);

JScrollPane scroller = new JScrollPane(tree);
frame.add(scroller);
frame.pack();
frame.setVisible(true);