private static class TreeEditorFocusTraversalPolicy extends DefaultFocusTraversalPolicy {
    private final JTree tree;
    public TreeEditorFocusTraversalPolicy(JTree tree) {
        this.tree = tree;
    }

    @Override
    public Component getComponentAfter(Container aContainer, Component aComponent) {
        if (aComponent instanceof CellEditor) {
            return tree;
        }
        return super.getComponentAfter(aContainer, aComponent); 
    }
}