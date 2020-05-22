public int [] getMonth() throws ParseException{
    String [] date=getDate();
    int[] month = new int[date.length]; // here's the missing line
    DateFormat df= new SimpleDateFormat("MM.dd.yy hh:mm");
    Date [] result= new Date [date.length];

    for (int i=0; i<date.length; i++){
        Calendar cal= Calendar.getInstance();
        result[i]=df.parse(date[i]);
        cal.setTime(result[i]);
        month[i]=cal.get(Calendar.MONTH);
    }
    return month;
}