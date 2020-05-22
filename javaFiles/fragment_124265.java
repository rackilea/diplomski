List<String> list = null;
String command = "SELECT itemName FROM item";

try {
    list = viewTable(conn, command);
} catch (SQLException e) {
    e.printStackTrace();
}

ComboBoxModel model = new DefaultComboBoxModel(list.toArray());
itemList.setModel(model);