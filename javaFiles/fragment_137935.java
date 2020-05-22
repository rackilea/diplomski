public class FirstNameOrder extends Order {
    public FirstNameOrder() {
        super("", true);
    }

    @Override
    public String toSqlString(Criteria criteria, CriteriaQuery criteriaQuery) throws HibernateException {
        return "case when upper(FIRST_NAME) like ? then 1 else 2 end";
    }
}