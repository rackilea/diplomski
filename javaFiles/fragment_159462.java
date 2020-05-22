class Item {

    // id of the item itself
    final String id;

    // id of the parent item
    final String parentId;

    // this list will contain the children of the given item
    // at the beginning this list is empty, and we are going to populate it
    final List<Item> children = new ArrayList<>();

    public Item(String id, String parentId) {
        this.parentId = parentId;
        this.id = id;
    }
}