public static void main(String args[]) throws Exception {
    String data = "2013-1-31 08:25 PM";
    DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd hh:mm a");
    Calendar cal = Calendar.getInstance();
    cal.setTime(fmt.parse(data));
    //2013-1-31
    System.out.println(new SimpleDateFormat("yyyy-M-dd").format(cal.getTime()));
    //20
    System.out.println(cal.get(Calendar.HOUR_OF_DAY));
    //08
    System.out.println(new SimpleDateFormat("hh").format(cal.getTime()));
}