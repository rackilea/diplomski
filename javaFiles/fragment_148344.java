Calendar c=Calendar.getInstance();
//If you Want Date
java.sql.Timestamp  sqlDate=resultSet.getTimestamp("dateColumn");<--From Database
SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");//One
System.out.println(sdf.format(sqlDate));
//If you Want time 
SimpleDateFormat sdf1=new SimpleDateFormat("HH:mm:SS.sss");//Two
System.out.println(sdf1.format(sqlDate));