//declaring host ,username and password 
    String host="jdbc:h2:tcp://localhost/~/test/INFORMATION_SCHEMA.COLLATIONS";
    String uName="sa";
    String uPass="sa";

    //giving a connection to the h2 database driver driver 
    Connection conn = DriverManager.getConnection("h2","sa","sa");