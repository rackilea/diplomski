public class CustomizedOrderBy extends Order {
    private String sqlExpression;

    protected CustomizedOrderBy(String sqlExpression) {
        super(sqlExpression, true);
        this.sqlExpression = sqlExpression;
    }

    public String toSqlString(Criteria criteria, CriteriaQuery criteriaQuery) throws HibernateException {
        return sqlExpression;
    }

    public static Order sqlFormula(String sqlFormula) {
        return new CustomizedOrderBy(sqlFormula);
    }

    public String toString() {
        return sqlExpression;
    }

}