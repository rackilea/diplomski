String str = "2014/01/01 18:02:02";
DateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
try {
    Date d = df.parse(str);
    System.out.println(df.format(d));
} catch (ParseException e) {
    e.printStackTrace();
}