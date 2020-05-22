private TreeView<String> cbTreeView; 
private final List<Wrap> disableList = new ArrayList<>();

@Override
public void start(Stage primaryStage) {
    cbTreeView = new TreeView();

    CheckBoxTreeItem<String> rootItem = new CheckBoxTreeItem("Serial No.");
    final List<CheckBoxTreeItem<String>> treeItems = new ArrayList<>(6);
    for (int i = 0; i < 6; i++) {
        CheckBoxTreeItem<String> item = new CheckBoxTreeItem("0"+i+"");
        item.setIndependent(true);
        treeItems.add(item);  
        disableList.add(new Wrap("0"+i+""));
    }
    rootItem.getChildren().addAll(treeItems);

    rootItem.setExpanded(true);
    rootItem.setIndependent(true);
    CheckBoxTreeItem<String> rootItem2 = new CheckBoxTreeItem("child1");
    final List<CheckBoxTreeItem<String>> treeItems2 = new ArrayList<>(6);
    for (int i = 0; i < 6; i++) {
        CheckBoxTreeItem<String> item = new CheckBoxTreeItem("1"+i+"");
        item.setIndependent(true);
        treeItems2.add(item); 
        disableList.add(new Wrap("1"+i+""));
    }
    rootItem2.getChildren().addAll(treeItems2);
    rootItem2.setIndependent(true);
    rootItem.getChildren().set(2,rootItem2);

    cbTreeView.setRoot(rootItem);