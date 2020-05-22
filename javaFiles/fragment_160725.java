public static Map<Integer, String> months() {
    Map<Integer, String> months = new HashMap<Integer, String>();
    for(int i=0;i<12;i++){
        GregorianCalendar cal = new GregorianCalendar(2000, i, 1);
        String month = new SimpleDateFormat("MMM", Locale.ENGLISH).format(cal.getTime());
        months.put(i + 1, month);
    }
    return months;
}