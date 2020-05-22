String lastCrawlDate = "2014-01-28";
Date utilDate = new SimpleDateFormat("yyyy-MM-dd").parse(lastCrawlDate);
// because PreparedStatement#setDate(..) expects a java.sql.Date argument
java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime()); 

Connection con = ...;
PreparedStatement p = con.prepareStatement("insert into JsonData (last_crawl_date) values(?))");
p.setDate(1, sqlDate);