Calendar c = new GregorianCalendar();
c.set(Calendar.HOUR_OF_DAY, 0);
c.set(Calendar.MINUTE, 0);
c.set(Calendar.SECOND, 0);
c.set(Calendar.MILLISECOND, 0);

Date currentDate = c.getTime();

Criteria criteria = session.createCriteria(Deal.class)
.add(Restrictions.gt("startDate", currentDate))     
.add(Restrictions.lt("endDate", currentDate));