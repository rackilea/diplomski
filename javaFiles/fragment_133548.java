public static LinkedList<Date> searchBetweenDates(Date startDate, Date endDate) throws SQLException {
    Date begin = new Date(startDate.getTime());
    LinkedList<Date> list = new LinkedList<Date>();

    list.add(new Date(begin.getTime()));

    endDate.setTime(endDate.getTime() + 24 * 3600 * 1000);
    Calendar cal = Calendar.getInstance();
    cal.setTime(begin);

    dbConnection = getDBConnection();
    PreparedStatement ps = dbConnection.prepareStatement("INSERT INTO cmd1(aaaa, bbbb, datee, timee) VALUES(?, ?, ?, ?)");
    while (begin.compareTo(endDate) < 0) {
        begin = new Date(begin.getTime() + 86400000);
        list.add(new Date(begin.getTime()));
        Timestamp timestamp = new Timestamp(new Date().getTime());

        // For a single day calculation: 24hours*60mins=1440 /2 (2 mins time
        // difference as per the requirement) = 720

        for (int j = 0; j < 720; j++) {
            cal.add(Calendar.MINUTE, 2);
            timestamp = new Timestamp(cal.getTime().getTime());
            String S = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(timestamp);
            String[] parts = S.split(" ");
            String date = parts[0];
            String time = parts[1];
            cal.getTime().toString();

            // To create data loop into a List
            for (int i = 1; i <= total; i++) {

                int a2 = 220 + j % 31; // 230 - 244 by 1
                String a = String.valueOf(a2);
                double b2 = 0.00 + j % 3.7; // 1.3 - 3.9 by 0.1
                String b = String.valueOf(b2);
                b = b.substring(0, Math.min(b.length(), 5));

                ps.setString(1, a);
                ps.setString(2, b);
                ps.setString(3, date);
                ps.setString(4, time);

                ps.execute();
            }
        }
    }
    if (ps != null)
        ps.close();
    if (dbConnection != null)
        dbConnection.close();

    return list;
}