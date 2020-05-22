List<Object[]>  allJourney = query.list(); 
  //do what ever you need to do with result:
  for (Object[] row: allJourney) {
      Integer id = (Integer) row[0];
      Date operatingday = (Date) row[1];
  }