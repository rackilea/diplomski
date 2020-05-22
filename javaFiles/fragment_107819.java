CronSequenceGenerator cronGen = new CronSequenceGenerator("0 0 19 15-21 1,4,7,10 FRI");
java.util.Date date = java.sql.Date.valueOf("2018-01-01");
for (int i = 0; i < 12; i++) {
    date = cronGen.next(date);
    System.out.println(new java.text.SimpleDateFormat("EEE, MMM d, yyyy 'at' hh:mm:ss a").format(date));
}