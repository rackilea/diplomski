private List<String> viewTable(Connection con, String command) {
    List<String> list = new ArrayList<>();
    ...
    while (rs.next()) {
        list.add(rs.getString("itemName"));
    }
    return list;
}