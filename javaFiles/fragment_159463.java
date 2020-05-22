List<Item> constructForest(Item... items) {
    Map<String, Item> itemIdToItem = indexItemsById(items);
    List<Item> roots = attachToParents(itemIdToItem, items);
    return roots;
}

/**
 * Index all items by item id.
 * Returns the mapping from the item id to item.
 */
Map<String, Item> indexItemsById(Item... items) {
    Map<String, Item> itemIdToItem = new HashMap<>();
    for (Item item : items) {
        itemIdToItem.put(item.id, item);
    }
    return itemIdToItem;
}

/**
 * Attaches the children nodes to the parent nodes
 * Returns the list of root nodes of the constructed forest
 */
List<Item> attachToParents(Map<String, Item> itemIdToItem, Item... items) {

    List<Item> roots = new ArrayList<>();

    for (Item item : items) {
        if (item.parentId == null) {
            roots.add(item);
        } else {
            Item parent = itemIdToItem.get(item.parentId);
            parent.children.add(item);
        }
    }

    return roots;
}