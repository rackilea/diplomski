public static void getDate(){
    GregorianCalendar cal = new GregorianCalendar();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");

    int day = cal.get(GregorianCalendar.DAY_OF_MONTH);


        for(int i=day; i > (day-5); i--){
            cal.set(GregorianCalendar.DAY_OF_MONTH, i);

            Date date = cal.getTime();
            System.out.println(sdf.format(date));   
        }

}