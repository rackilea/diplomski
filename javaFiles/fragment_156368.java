private TreeItem<MyType> buildSubtree(MyType root) {
    TreeItem<MyType> result = new TreeItem<>(root);

    if (root.getChildren() != null) {
        for (MyType child : root.getChildren()) {
            result.getChildren().add(buildSubtree(child));
        }
    }

    return result;
}