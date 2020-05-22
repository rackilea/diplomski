Calendar cal = Calendar.getInstance(TimeZone.getDefault(), Locale.getDefault()) ;
SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.getDefault());
try {
        Date date = dateformat.parse("2015-08-10T21:00:00.090Z");
        cal.setTime(date);
        String result = new SimpleDateFormat("MM dd", Locale.getDefault()).format(cal.getTime());
        System.out.println(result);

} catch (ParseException e) {
        e.printStackTrace();
}