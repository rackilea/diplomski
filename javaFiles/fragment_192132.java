tree = new JTree(root);
if (tree.getCellRenderer() instanceof DefaultTreeCellRenderer)
{
    final DefaultTreeCellRenderer renderer = 
        (DefaultTreeCellRenderer)(tree.getCellRenderer());
    renderer.setBackgroundNonSelectionColor(Color.YELLOW);
    renderer.setBackgroundSelectionColor(Color.ORANGE);
    renderer.setTextNonSelectionColor(Color.RED);
    renderer.setTextSelectionColor(Color.BLUE);
}
else
{
    System.err.println("Sorry, no special colors today.");
}