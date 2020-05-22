public static void createTree(File file, CheckBoxTreeItem<String> parent) {
    if (file.isDirectory()) {
        CheckBoxTreeItem<String> treeItem = new CheckBoxTreeItem<>(file.getName());
        parent.getChildren().add(treeItem);
        for (File f : file.listFiles()) {
            createTree(f, treeItem);
        }
    } else if (".php".equals(Util.retrieveFileType(file.toString()))) {
        parent.getChildren().add(new CheckBoxTreeItem<>(file.getName()));
    }
}