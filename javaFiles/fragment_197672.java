public class MCBPostgreSQL9Dialect extends PostgreSQL94Dialect {

        public MCBPostgreSQL9Dialect() {
            super();
            registerFunction("string_agg", new StandardSQLFunction("string_agg", new org.hibernate.type.StringType()));
            registerFunction("to_char", new StandardSQLFunction("to_char"));
            registerFunction("trim", new StandardSQLFunction("trim"));
        }
    }