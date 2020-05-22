Criteria criteria = session.createCriteria(Sale.class);
if (startDate != null) {
  criteria.add(Expression.ge("date",startDate);
}
if (endDate != null) {
  criteria.add(Expression.le("date",endDate);
}
List results = criteria.list();