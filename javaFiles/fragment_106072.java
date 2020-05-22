void addChildren(MultiAdminComponent parent, List<MultiAdminComponent> children) {
    if(null != parent.getItems()) {
        for(MultiAdminComponent child : parent.getItems()) {
            children.add(child);
            addChildren(child, children);
        }
    }
}