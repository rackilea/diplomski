class ReticentTreeUI extends BasicTreeUI {

    private Set<Integer> hiddenRows = new HashSet<Integer>();

    public void hideRow(int row) {
        hiddenRows.add(row);
    }

    @Override
    protected void paintHorizontalPartOfLeg(Graphics g,
        Rectangle clipBounds, Insets insets, Rectangle bounds,
        TreePath path, int row, boolean isExpanded,
        boolean hasBeenExpanded, boolean isLeaf) {
        if (!hiddenRows.contains(row)) {
            super.paintHorizontalPartOfLeg(g, clipBounds, insets, bounds,
                path, row, isExpanded, hasBeenExpanded, isLeaf);
        }
    }

    @Override
    protected void paintRow(Graphics g, Rectangle clipBounds,
        Insets insets, Rectangle bounds, TreePath path, int row,
        boolean isExpanded, boolean hasBeenExpanded, boolean isLeaf) {
        if (!hiddenRows.contains(row)) {
            super.paintRow(g, clipBounds, insets, bounds, path, row,
                isExpanded, hasBeenExpanded, isLeaf);
        }
    }

    @Override
    protected void paintExpandControl(Graphics g, Rectangle clipBounds,
        Insets insets, Rectangle bounds, TreePath path, int row,
        boolean isExpanded, boolean hasBeenExpanded, boolean isLeaf) {
        if (!hiddenRows.contains(row)) {
            super.paintExpandControl(g, clipBounds, insets, bounds,
                path, row, isExpanded, hasBeenExpanded, isLeaf);
        }
    }
}