private String getCurrentTimeDate() {

    Calendar calendar = new GregorianCalendar();
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

    return formatter.format(calendar.getTime());
}