private void expandTreeView(TreeItem<?> item){
    if(item != null && !item.isLeaf()){
        item.setExpanded(true);
        for(TreeItem<?> child:item.getChildren()){
            expandTreeView(child);
        }
    }
}