Map<String,MenuItem> items = new HashMap<>();
Map<String,String> parentMap = new HashMap<>();
// Fill the maps
try (Connection cnt = openConnection();
        PreparedStatement stmt = cnt.prepareStatement("SELECT * FROM menus");
        ResultSet rs = stmt.executeQuery()) {
    while (rs.next()) {
        MenuItem item = new MenuItem();
        item.setId(rs.getString("id"));
        item.setLabel(rs.getString("label"));
        item.setLink(rs.getString("link"));
        items.put(item.getId(), item);
        String parent = rs.getString("parent");
        if (parent != null && !parent.equals("0")) {
            parentMap.put(item.getId(), parent);
        }
    }
}
// Resolve the hierarchy
for (Map.Entry<String,String> e: parentMap.entrySet()) {
    MenuItem item = items.get(e.getKey());
    String parentId = e.getValue();
    MenuItem parent = items.get(parentId);
    item.setParent(parent);
    if (parent != null) {
        parent.addChild(item);
    }
}
// Remove all items that have a parent
for (String id: parentMap.keySet()) {
    items.remove(id);
}