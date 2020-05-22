fixed.addTreeExpansionListener(new TreeExpansionListener() {

    @Override
    public void treeExpanded(TreeExpansionEvent event) {
            main.expandPath(event.getPath());
    }

    @Override
    public void treeCollapsed(TreeExpansionEvent event) {
        main.collapsePath(event.getPath());
    }
});