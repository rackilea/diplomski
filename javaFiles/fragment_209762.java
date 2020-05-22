String time = "Sun Sep 14 02:00:00 PDT 2014";
DateFormat out = new SimpleDateFormat("yyyy-MM-dd");
DateFormat in = new SimpleDateFormat("EEE MMM dd kk:mm:ss z yyyy");
try {
    Date effectiveDate = in.parse(time);
    System.out.println("Date: " + out.format(effectiveDate));
} catch (ParseException e) {
    e.printStackTrace();
}