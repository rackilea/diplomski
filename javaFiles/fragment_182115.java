private String convertDateToLocal(Date createDate, String timeZone) {
    Long dbDate = createDate.getTime();
    DateTimeFormatter fmt = DateTimeFormat.forPattern("MM/dd/yyyy hh:mm a zz");
    DateTime origDate = new DateTime(dbDate);
    DateTime dtTz = origDate.withZone(DateTimeZone.forID(timeZone));
    return dtTz.toString(fmt);
}