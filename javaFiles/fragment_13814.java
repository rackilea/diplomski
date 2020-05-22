public static void updateRecord(LeaderRecord leader) {
    long timeLimit = 5000;//ms
    Timer timer = new Timer();
    timer.schedule(new TimerTask() {
        @Override
        public void run() {
            calendar.add(Calendar.SECOND, timeLimit);
            leader.setExpiryTime(new Timestamp(calendar.getTime().getTime()));
            data.put(leader.getType(), leader);
            System.out.println(record.getExpiryTime());
        }
    }, 0, timeLimit);// Delay, Time Between in ms
}