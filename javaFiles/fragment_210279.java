nodes.values().forEach( node ->
    node.setChildren(
        hierarchies.stream()
            .filter(h -> h.getParentMenu().getId() == node.getData().getId())
            .sorted(comparing(MenuHierarchy::getDisplayOrder))
            .map(MenuHierarchy::getChildMenu)
            .map(MenuItem::getId)
            .map(nodes::get)
            .collect(toList())
    )
);