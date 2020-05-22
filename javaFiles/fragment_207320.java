Criteria criteria = getSession().createCriteria(Employee.class);

Criterion whereClause = Restrictions.eq("id", employeeId);
if (interval > 0) {
    String sql = "{alias}.create_date > DATE_SUB(NOW(), INTERVAL " + interval + " SECOND) OR {alias}.modified_date > DATE_SUB(NOW(), INTERVAL " + interval + " SECOND)";
    Criterion andConjunction = Restrictions.and(
        whereClause, 
        Restrictions.sqlRestriction(sqlWhere)
    );

    whereClause = andConjunction;
}
criteria.add(whereClause);

List<Employee> employeeList = criteria.list();