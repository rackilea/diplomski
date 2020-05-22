long time = System.currentTimeMillis();
Calendar cal = Calendar.getInstance();
cal.setTimeInMillis(time);
for (String id : TimeZone.getAvailableIDs()) {
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
    formatter.setTimeZone(TimeZone.getTimeZone(id));
    System.out.printf(
        "The current time in %s is %s%n",  id, formatter.format(cal.getTime())
    );
}