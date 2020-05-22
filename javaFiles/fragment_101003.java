public void valueChanged(TreeSelectionEvent e) {

    DefaultMutableTreeNode node = (DefaultMutableTreeNode)
                       tree.getLastSelectedPathComponent();

    if (node == null) {
    //since Nothing is selected.     
     return;
    }

    Object nodeObject = node.getUserObject();
    System.out.println("Selected node : " + nodeObject);
}