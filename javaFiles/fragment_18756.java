Category categoryItem = (CategoryItem)jComboBox1.getSelectedItem();

insert = con1.prepareStatement("INSERT INTO product (productname, description, name) VALUES (?,?,?)");

insert.setString(1, productname);
insert.setString(2, productdec);
insert.setString(3, categoryItem.name);