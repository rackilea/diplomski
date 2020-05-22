Statement statement = ...;
String queryString = "SELECT s.name sname,s.city scity,f.name fname, f.city fcity, su.name suname, su.city sucity "
        +" FROM `order_details` ot "
        +" INNER JOIN `order` o ON ot.odr_id = o.odr_id "
        +" INNER JOIN `product` p ON ot.pro_id = p.id "
        +" INNER JOIN `firm` f ON o.firm_id = f.id "
        +" INNER JOIN `shipp` s ON o.shipp_id = s.id "
        +" INNER JOIN `supplier` su ON o.sup_id = su.id ";
ResultSet resultSet = statement.executeQuery(queryString);
ResultSetMetaData metaData = resultSet.getMetaData();
int colCount = metaData.getColumnCount();
if (resultSet.next()) {
    for (int i = 1; i <= colCount; i++) {
        System.out.println("Col(" + i + ") '" + metaData.getColumnName(i) + "' value:" + resultSet.getString(i));
    }
}else{
   System.out.println("No row found.");
}