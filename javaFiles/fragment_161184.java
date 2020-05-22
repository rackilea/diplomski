public static void main(String[] args) throws ParseException {
    String s = "09-Mar-2015 17:05:04 PM";
    System.out.println("before parsing " + s);
    SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy hh:mm:ss");
    Date d = sdf.parse(s);
    System.out.println("date " + d);
    String format = sdf.format(d);
    System.out.println("after  format  " + format);

}