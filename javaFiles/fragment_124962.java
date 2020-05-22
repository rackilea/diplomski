final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
try {
    final String displayDate = dateFormat.format(new Date());
} catch (ParseException e) {
    // ...
}