public List<TimeSeriesPowerPK> getPowerUsageForUser(String minutes) {
Query query = sessionFactory.getCurrentSession().createQuery("From TimeSeriesPowerPK where dateTime <=:param1 AND dateTime >= :parma2 ");
query.setParameter("param1",currentDateObject);
query.setParameter("param2",userEnteredDateObject);
List<TimeSeriesPowerPK> powerUsedList=query.list();
return powerUsedList;