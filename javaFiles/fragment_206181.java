@BindingAnnotation(BindWhereClause.WhereClauseBinderFactory.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.PARAMETER})
public @interface BindWhereClause {
    class WhereClauseBinderFactory implements BinderFactory {
        public Binder build(Annotation annotation) {
            return new Binder<BindWhereClause, WhereClause>() {
                public void bind(SQLStatement q, BindWhereClause bind, WhereClause clause) {
                    clause.queryValues
                            .keySet()
                            .forEach(s -> q.bind(s, clause.queryValues.get(s)));
                }
            };
        }
    }
}