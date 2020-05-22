public static void main(String[] args) {
    Date date = new Date();
    SimpleDateFormat format = new SimpleDateFormat("E MMM  dd HH:mm:ss:SS z");
    format.setTimeZone(TimeZone.getTimeZone("UTC"));
    System.out.println(format.format(date));
}