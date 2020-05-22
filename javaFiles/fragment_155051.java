DefaultTableModel model = (DefaultTableModel) tblMenu.getModel();
while (rs.next()) {
    String menu_id = rs.getString("menu_id");
    String menu_type = rs.getString("menu_type");
    String menu_cat = rs.getString("menu_cat");
    String menu_name = rs.getString("menu_name");
    String menu_price = rs.getString("menu_price");

    model.addRow(new Object[]{menu_id, menu_type, menu_cat, menu_name, menu_price});
}