public static void main(String[] args) {
    String dateString = "/Date(1370257470183+0530)/";

    String longString = dateString.substring(6, dateString.indexOf('+'));
    String gmtString = dateString.substring(dateString.indexOf('+'), dateString.indexOf(')'));

    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    format.setTimeZone(TimeZone.getTimeZone(gmtString));
    Date date = new Date(Long.parseLong(longString));
    System.out.println(format.format(date));

}