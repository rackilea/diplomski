public static void getDate1(){
    GregorianCalendar cal = new GregorianCalendar();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");

    cal.set(2013, 0, 1); // this is extreme case!!!

    int day = cal.get(GregorianCalendar.DAY_OF_MONTH);
    int month = cal.get(GregorianCalendar.MONTH);
    int year = cal.get(GregorianCalendar.YEAR);

        for(int i=day; i > (day-5); i--){
            cal.set(year, month, i);

            Date date = cal.getTime();
            System.out.println(sdf.format(date));   
        }

}