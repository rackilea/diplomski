List<String> soldWhich = null;
try {
    Class.forName(DRIVER);  
    con1 = DriverManager.getConnection(URL, username, password);  
    String sql = "SELECT home_id FROM Home";  
    stmt1 = con1.createStatement();  
    rs1 = stmt1.executeQuery(sql);  
    soldWhich = new ArrayList<String>();

    while (rs1.next()){
        for (int i=1;i<=rs1.getRow(); i++ ){
            String value = rs1.getString(1);
            soldWhich.add(value);
        }
    }
}