DatabaseMetaData meta = con.getMetaData();
  ResultSet res = meta.getTables(null, null, null, 
     new String[] {"TABLE"});
  System.out.println("List of tables: "); 
  while (res.next()) {
     System.out.println(
        "   "+res.getString("TABLE_CAT") 
       + ", "+res.getString("TABLE_SCHEM")
       + ", "+res.getString("TABLE_NAME")
       + ", "+res.getString("TABLE_TYPE")
       + ", "+res.getString("REMARKS")); 
  }
  res.close();