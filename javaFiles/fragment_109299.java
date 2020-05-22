ResultSet rs = stmt.executeQuery(sql);  
System.out.println("!");  
System.out.println("->"+rs.getFetchSize());  

rs.beforeFirst();  
rs.last();  
int rowCount = rs.getRow();  
System.out.println( "---> rowCount: " + rowCount );  
rs.beforeFirst();  

while( ...