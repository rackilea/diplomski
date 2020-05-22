@Retention(RetentionPolicy.RUNTIME)
@Target({FIELD,METHOD,PARAMETER,TYPE})
@Qualifier
public @interface DbType {
    /**
     * If this DbType is part of the initialization process for an existing DB
     */
    boolean init() default false;

    class Literal extends AnnotationLiteral<DbType> implements DbType {

        public static Literal INIT = new Literal(true);
        public static Literal NO_INIT = new Literal(false);

        private final boolean init;

        private Literal(boolean init) {
            this.init = init;
        }

        @Override
        public boolean init() {
            return init;
        }

    }

}