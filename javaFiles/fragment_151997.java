public class TreeItem<T extends TreeItem>{

    private final ObservableList<T> childs;
    private TreeItem parent;

    public TreeItem(ObservableList<T> childs) {
        this.childs = childs;
    }

    public void addChild(T unit){
        childs.add(unit);
        unit.setParent(this);
    }

    public void setParent(TreeItem parent){
        this.parent = parent;
    }

    public TreeItem getParent() {
        return parent;
    }
}