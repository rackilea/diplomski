StatisticsManager statsMan = new FBStatisticsManager();
statsMan.setHost("localhost");
statsMan.setDatabase("/path/to/your.fdb");
statsMan.setUser("youruser");
statsMan.setPassword("yourpassword"); 
DatabaseTransactionInfo info = statsMan.getDatabaseTransactionInfo();