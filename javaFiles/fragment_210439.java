@Transient
public int getDuration() {
    int days = 0;
    try{
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
         Date dstart = sdf.parse(start);
         Date dend = sdf.parse(end);
         long milsecs = dend.getTime() = dstart.getTime();
         days = (int)(milsec/(MILLIS_IN_A DAY)); 
    }catch(ParseException pe){
    ;
    }
    return days;
}