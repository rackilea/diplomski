if (temp!=null){
 if (temp.getSummary().equals(CalendarHelper.EventType.off)){
        return false;
 }
  if  (temp.getSummary().equals(CalendarHelper.EventType.work)){
        return true;
 }
}