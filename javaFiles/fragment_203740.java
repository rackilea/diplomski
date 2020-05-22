public class DateLikeExpression implements Criterion {

private static final long serialVersionUID = 1L;
private String propertyName;
private String value;

public DateLikeExpression(String propertyName, String value) {
    this.propertyName = propertyName;
    this.value = value;
}

public String toSqlString(Criteria criteria, CriteriaQuery criteriaQuery) throws HibernateException {
    String[] columns = criteriaQuery.getColumnsUsingProjection(criteria, propertyName);
    if (columns.length != 1) {
        throw new HibernateException("Like may only be used with single-column properties");
    }
    return "to_char(" + columns[0] + ", 'DD/MM/YYYY HH24:MI') like ?";
}

public TypedValue[] getTypedValues(Criteria criteria, CriteriaQuery criteriaQuery) throws HibernateException {
    return new TypedValue[] { new TypedValue(new org.hibernate.type.StringType(),
            MatchMode.START.toMatchString(value.toLowerCase()), EntityMode.POJO) };
}

}