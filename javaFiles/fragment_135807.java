java.sql.Timestamp timeStamp = new Timestamp(rs.getDate(1));
java.sql.Date date = new java.sql.Date(timeStamp.getTime()); 
System.out.println(date);

DateFormat formatter = new SimpleDateFormat("dd MMM yyyy");
formatter.format(date);
System.out.println(date);