final static Criterion NOOP_CRITERION = new Criterion() 
{
       @Override public String 
    toSqlString(Criteria criteria, CriteriaQuery criteriaQuery) {
            return "1=1";
        }
       @Override public TypedValue[] 
    getTypedValues(Criteria criteria, CriteriaQuery criteriaQuery) {
            return new TypedValue[0];
        }
}