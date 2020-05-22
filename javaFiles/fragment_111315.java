MouseListener mouseListenerForAllTrees = new MouseAdapter() {
    @Override
    public void mouseClicked(MouseEvent e) {
        // deselect all trees except the one which fired the event
        for (JTree tree : allTrees) {
            if (tree != e.getSource())
                tree.clearSelection();
        }
    }
};
for (JTree tree : allTrees) {
    tree.addMouseListener(mouseListenerForAllTrees);
}