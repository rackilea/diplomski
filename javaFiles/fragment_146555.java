java.util.Date utilDate = new java.util.Date();

java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

System.out.println("sqlDate equals utilDate:\t" + sqlDate.equals(utilDate));
System.out.println("utilDate equals sqlDate:\t" + utilDate.equals(sqlDate));

java.sql.Time time = new java.sql.Time(utilDate.getTime());

System.out.println("time equals utilDate:\t\t" + time.equals(utilDate));
System.out.println("utilDate equals time:\t\t" + utilDate.equals(time));

java.sql.Timestamp timestamp = new java.sql.Timestamp(utilDate.getTime());

System.out.println("timestamp equals utilDate:\t" + timestamp.equals(utilDate));
System.out.println("utilDate equals timestamp:\t" + utilDate.equals(timestamp));