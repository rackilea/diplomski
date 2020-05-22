private String getPath(TreeItem selectedItem) {
    StringBuilder builder = new StringBuilder();
    buildPath(selectedItem, builder);
    return builder.toString();
}

private void buildPath(TreeItem item, StringBuilder builder) {
    if (item.getParentItem() != null) {

        buildPath(item.getParentItem(), builder);  //build path

        builder.append('/');
    }
    builder.append(item.getText());
}