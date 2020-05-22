public static void main(){
JDateChooser dateChooser = new JDateChooser();    
List<Date> dates = new ArrayList<Date>();
Calendar c = Calendar.getInstance();
c.set(Calendar.YEAR, desiredyear);
c.set(Calendar.MONTH, desiredmonth);
c.set(Calendar.DAY_OF_MONTH, desiredday);
c.set(Calendar.HOUR_OF_DAY, 0);
c.set(Calendar.MINUTE, 0);
c.set(Calendar.SECOND, 0);
c.set(Calendar.MILLISECOND, 0);
dates.add(c.getTime());
HighlightEvaluator evaluator = new HighlightEvaluator();
evaluator.setDates(dates);    
dateChooser.getJCalendar().getDayChooser().addDateEvaluator(evaluator);
}