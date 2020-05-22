public static void main(final String[] args) throws Exception {
    final SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
    final String currentDateandTime = " 9/4/2014 3:55:10 AM ";
    final Date date = sdf.parse(currentDateandTime);
    final Calendar calendar = Calendar.getInstance();

    calendar.setTime(date);
    calendar.add(Calendar.HOUR, 10);

    System.out.println("Time here " + calendar.getTime());
}