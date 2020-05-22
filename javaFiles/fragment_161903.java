package org.superbiz.provider;

import org.apache.openejb.api.resource.PropertiesResourceProvider;
import org.apache.openejb.testng.PropertiesBuilder;

import java.util.Properties;

public class MyPropertiesReader implements PropertiesResourceProvider {
    public Properties provides() {
        return new PropertiesBuilder()
                .p("JdbcDriver", "org.hsqldb.jdbcDriver")
                .p("JdbcUrl", "jdbc:hsqldb:mem:moviedb")
                .build();
    }
}