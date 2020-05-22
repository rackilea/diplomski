TreePathSupport tps = outlineModel.getTreePathSupport();
tps.addTreeExpansionListener(new TreeExpansionListener() {

    @Override
    public void treeExpanded(TreeExpansionEvent e) {
        System.out.println(e.getPath());
    }

    @Override
    public void treeCollapsed(TreeExpansionEvent e) {
        System.out.println(e.getPath());
    }
});