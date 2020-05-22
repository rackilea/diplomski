String name = idValues.getStringExtra("ORGNAME");    

if (name.contains("'")) {
   // Should replace all the charecters
   name = name.replaceAll("'", "''");
}

String sql ="select orgname from table1 where name like '%"+ name +"%'  Order by org.name";