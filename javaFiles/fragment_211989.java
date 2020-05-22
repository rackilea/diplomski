ResultSet resultSet = <custom_class_for_hive_jdbc_connector>.executeQuery("DESCRIBE <TABLE_NAME>");
ResultSetMetaData metaData = resultSet.getMetaData();
while (resultSet.next()) {

System.out.println(" Column names : "+resultSet.getString(metaData.getColumnName(1)));

}