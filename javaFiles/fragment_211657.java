DateRange dateRange;
if(...){
   dateRange = (DateRange)it.next();
}
else{
   dateRange = new DateRange();
   ...
   session.save(dateRange);
}