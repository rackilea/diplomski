public static void main(String[] args) throws Exception {
    SimpleDateFormat format = new SimpleDateFormat("d MMM yyyy");
    Date installDate = format.parse("1 Jan 2012");
    Date payDate = format.parse("1 Feb 2012");
    long localDatePay = payDate.getTime();
    long localDateInstall = installDate.getTime();
    long days = Math.abs(localDatePay - localDateInstall) / 86400000;
    System.out.println(days);
}