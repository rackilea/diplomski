class ChildTreeItem<T extends TreeItem> extends TreeItem<T> {
    public ChildTreeItem(ObservableList childs) {
        super(childs);
    }
}



public class TreeItem<T extends TreeItem>{

    private final ObservableList<T> childs;
    private T parent;

    public TreeItem(ObservableList<T> childs) {
        this.childs = childs;
    }

    public void addChild(T unit){
        childs.add(unit);
        unit.setParent(this);
    }

    public void setParent(T parent){
        this.parent = parent;
    }

    public T getParent() {
        return parent;
    }

    public static void main(String[] args) {
        ChildTreeItem<ChildTreeItem> treeItem =
            new ChildTreeItem<>(new ObservableSequentialListWrapper<>(new ArrayList<>()));
        TreeItem<ChildTreeItem> parentItem =
            new TreeItem<>(new ObservableSequentialListWrapper<>(new ArrayList<>()));

        parentItem.addChild(treeItem);
        List<ChildTreeItem> itemList = new ArrayList<>();
        itemList.add(treeItem.getParent()); //<------------------- Heap pollution

        ChildTreeItem childTreeItem = itemList.get(0); //<-------- ClassCastException
    }
}