protected void processRecords(String countryName) {
  ThreadPoolExecutor executor = new ThreadPoolExecutor(10, 10, 10, TimeUnit.SECONDS, 
        new ArrayBlockingQueue<Runnable>(5), new ThreadPoolExecutor.CallerRunsPolicy());

   List<String[]> emaillist = new ArrayList<String>(1000);

   ResultSet rs = ....

   try {
     while (rs.next()) {
        String user[] = new String[2];
        users[0] = rs.getString("userid");
        users[1] = rs.getString("emailAddress");

        emaillist.add(user);
        if (emaillist.size() == 1000) {
            final List<String[]> elist = new ArrayList<String[]>(emaillist);
            executor.execute(new Runnable() {
                public void run() {
                    sendMail(elist);
                }
            }
            emaillist.clear();
        }
     }
   }
   finally {
     DbUtils.close(rs);
   }

   if (! emaillist.isEmpty()) {
            final List<String[]> elist = emaillist;
            executor.execute(new Runnable() {
                public void run() {
                    sendMail(elist);
                }
            }
            emaillist.clear();
   }

   // wait for all the e-mails to finish.
   while (! executor.isTerminated()) {
       executor.shutdown();
       executor.awaitTermination(10, TimeUnit.DAYS);
   }


}