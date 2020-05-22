String jk =" where nam='"+txt1.getText()+"'";                
String ik =" and password='"+txt2.getPassword()+" ' ";                                              

    String sql;                 
sql = "SELECT * FROM Table1" +jk+ik;                        
rs = stmt.executeQuery(sql);