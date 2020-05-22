private static Date getTonight10PM() {
        Calendar today = new GregorianCalendar();
        Calendar result =
            new GregorianCalendar(today.get(Calendar.YEAR), today.get(Calendar.MONTH), today.get(Calendar.DATE), 23, 0);
        return result.getTime();
}