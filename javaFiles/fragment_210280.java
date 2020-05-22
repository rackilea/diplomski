hierarchies.stream()
    .filter(h -> null != h.getParent())
    .collect(
        groupingBy(h->g.getParentMenu().getId(), toList())
    ) // now we have a map of parent Ids to list of MenuHierarchy for that parent
    .forEach( (parentId, children) ->
        nodes.get(parentId)).setChildren(
            children.stream()
                .sorted(comparing(MenuHierarchy::getDisplayOrder))
                .map(h -> nodes.get(h.getChildMenu().getId()))
                .collect(toList())
        )
    );