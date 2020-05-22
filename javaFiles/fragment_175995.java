while (rs.next()) {
   String tableCatalog = rs.getString(1);
   String tableSchema = rs.getString(2);
   String tableName = rs.getString(3);
   Tables.addComponent(new Checkbox(tableName,cbg,false););
}