public boolean is_error(Event temp, int anz) throws IOException{
    if (temp!=null){
        if (temp.getSummary().equals(CalendarHelper.EventType.off)){
            return false;
         }
         if  (temp.getSummary().equals(CalendarHelper.EventType.work)){
            return true;
         }
         //for fun do this:
         throw new RuntimeException("no equals is good");
     }
     return is_error(this.getLastWorkRelevantEvent(new Date(System.currentTimeMillis()-anz*24*60*60*1000L)),++anz);
}