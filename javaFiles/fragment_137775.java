SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

SimpleDateFormat sdfLocal = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");

try {
    String d = sdf.format(new Date());
    System.out.println(d);
    System.out.println(sdfLocal.parse(d));
} catch (Exception e) {
    e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
}