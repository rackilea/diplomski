// first we make all the nodes and map them to ID
Map<Long, MenuNode> nodes = hierarchies.stream()
    .map(MenuHierarchy::getChildMenu)
    .collect(toMap(MenuItem::getId, MenuNode::new));

// and now we go over all hierarchies and add children to appropriate node
hierarchies.stream()
    .filter(h -> h.getParent() != null)
    .sorted(comparing(MenuHierarchy::getDisplayOrder))
    .forEach(h -> {
        long parentId = h.getParentMenu().getId();
        long childId  = h.getChildMenu().getId();
        nodes.get(parentId).getChildren().add(nodes.get(childId))
    });