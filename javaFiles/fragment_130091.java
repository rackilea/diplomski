package com.mypkg.dialect;

import org.hibernate.dialect.Oracle10gDialect;
import org.hibernate.dialect.function.StandardSQLFunction;
import org.hibernate.type.StringType;

public class CustomOracle10gDialect extends Oracle10gDialect {

    public CustomOracle10gDialect() {
        super();
        registerFunction("my_function"
           , new StandardSQLFunction("my_function", new StringType()));
    }
}