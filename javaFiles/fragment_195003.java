List<Week> weekList= new ArrayList<Week>();
List<Week> weeks = dao.findAllGreaterThanWeekAndYear(...)
List<Week> weeks = dao.findAllBetween(...)

for(Week week : weeks){
 weekList.add(week);
 //TODO: add static getCurrentWeek and override equals
 if(week.equals(Week.getCurrentWeek())){
      break;            
}