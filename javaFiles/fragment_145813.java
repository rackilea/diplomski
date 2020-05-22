private void collapseTreeView(TreeItem<?> item){
    if(item != null && !item.isLeaf()){
        item.setExpanded(false);
        for(TreeItem<?> child:item.getChildren()){
            collapseTreeView(child);
        }
    }
}