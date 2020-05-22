CategoryItem item = (CategoryItem)jComboBox1.getSelectedItem();
int id = item.id;

query.prepareStaement("UPDATE category SET productname = ? WHERE id = ?");
query.setString(1, "new product name");
query.setInt(2, id);