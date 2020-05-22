Connection con = DriverManager.getConnection("jdbc:mysql://localhost/foobar", "root", "password");
Statement stmt = con.createStatement();
String sql = 
    "load data infile 'c:/temp/some_data.txt' \n" +
    "   replace \n" +
    "   into table prd \n" +
    "   columns terminated by '\\t' \n" +
    "   ignore 1 lines";
stmt.execute(sql);