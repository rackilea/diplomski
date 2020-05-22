try{
     String x="2019-04-04T21:24:33+00:00";
     DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ssX");
     Date date = (Date) df.parse(x);
     java.sql.Timestamp timeStamp = new java.sql.Timestamp(date.getTime());
 }catch(ParseException pe){
     pe.printStackTrace();
 }