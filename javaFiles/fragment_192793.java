String a = "19900416000000";
String b = "19900415000000";
DateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
df.setLenient(false);

for (String id : TimeZone.getAvailableIDs()) {
    df.setTimeZone(TimeZone.getTimeZone(id));
    try {
        df.parse(a);
    } catch (ParseException e) {
        System.out.println(id + ": " + e);
    }
    try {
        df.parse(b);
    } catch (ParseException e) {
        System.out.println(id + ": " + e);
    }
}