public String toSqlString(Criteria criteria, int loc, CriteriaQuery criteriaQuery) throws HibernateException {
  Dialect dialect = criteriaQuery.getFactory().getDialect();
  SQLFunction function = (SQLFunction) dialect.getFunctions().get(this.aggregate);
  //TODO: throw an exception if function is not registered

  //create function argument array
  List functionArgs = new ArrayList(1);
  functionArgs.add(criteriaQuery.getColumn(criteria, propertyName));

  return new StringBuffer()
    .append(function.render(functionArgs, criteriaQuery.getFactory()))
    .append(" as y").append(loc).append('_')
    .toString();
  }