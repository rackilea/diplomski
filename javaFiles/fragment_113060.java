public static void main(String[] args) {
    TreeItem<String> ti = new TreeItem<>("Hello world");
    TreeItem<String> ti2 = new TreeItem<>("42");
    TreeItem<String> ti3 = new TreeItem<>("Foo");
    TreeItem<String> ti4 = new TreeItem<>("Bar");
    ti.getChildren().addAll(ti2, ti3);
    ti2.getChildren().add(ti4);

    TreeItemTypeAdapter<String> adapter = new TreeItemTypeAdapter<>(String.class);
    Gson gson = new GsonBuilder().registerTypeAdapter(TreeItem.class, adapter).create();
    adapter.setGson(gson);

    System.out.println(gson.toJson(ti));
    System.out.println(toString(gson.fromJson("{\"value\":\"Hello world\",\"children\":[{\"value\":\"42\",\"children\":[{\"value\":\"Bar\",\"children\":[]}]},{\"value\":\"Foo\",\"children\":[]}]}",
            TreeItem.class)));
}

private static String toString(TreeItem ti) {
    StringBuilder sb = new StringBuilder("TreeItem [ value: \"").append(ti.getValue()).append("\" children [");
    boolean notFirst = false;
    for (TreeItem i : (List<TreeItem>) ti.getChildren()) {

        if (notFirst) {
            sb.append(",");
        } else {
            notFirst = true;
        }
        sb.append(toString(i));
    }
    return sb.append("]]").toString();
}