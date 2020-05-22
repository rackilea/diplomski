List<String> paths = ... ;
TreeItem<String> root = new TreeItem<>("root");
for (String path : paths) {
    TreeItem<String> current = root ;
    for (String component : path.split("\\.")) {
        current = getOrCreateChild(current, component);
    }
}

// ...

private TreeItem<String> getOrCreateChild(TreeItem<String> parent, String value) {

    for (TreeItem<String> child : parent.getChildren()) {
        if (value.equals(child.getValue())) {
            return child ;
        }
    }
    TreeItem<String> newChild = new TreeItem<>(value);
    parent.getChildren().add(newChild);
    return newChild ;
}