Calendar c=Calendar.getInstance();
  c.setTime(fromDate);
  c.add(Calendar.DATE,7);
  if(c.getTime().compareTo(toDate)<0){
    It's more than 7 days.
  }