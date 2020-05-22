QueryFilter filter = new QueryFilter();
 filter.addCriteria(Constants.Card.COURSE_CALL_NO, FilterOperator.ELEMENT_MATCH, courseCallNo);
 List<Course>  courseList =testRepository.find(filter);

 if(courseList != null && courseList.size()>0){
     course =courseList.get(0); 
 }