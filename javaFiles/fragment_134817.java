List<Thread> threads = new ArrayList<Thread>();
while (rs.next()) {
    Thread tread  = new Savescreenshots(rs.getString(1),rs.getString(3),rs.getString(2));
    tread.start();
    threads.add(thread);
}