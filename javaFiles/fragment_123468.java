String path = "file://C:/6-6+hf.1-181/db/mssql-ddl.sql";
    String path1 = URLEncoder.encode(path,"UTF-8");
    System.out.println(path1);
    String path2 = URLDecoder.decode(path1,"UTF-8");
    System.out.println(path2);

    //output
    file%3A%2F%2FC%3A%2F6-6%2Bhf.1-181%2Fdb%2Fmssql-ddl.sql
    file://C:/6-6+hf.1-181/db/mssql-ddl.sql