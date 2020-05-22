package at.rsf4j.core.db.hibernate.dialect;

import org.hibernate.dialect.InformixDialect;

/**
 * special dialect that asserts that Hibernate 4 works with a JDBC 3 Informix driver.
 * As soon as there is a JDBC 4 driver, this class can be deleted.
 */
public class InformixJdbc3Dialect extends InformixDialect {

    /**
     * this must return false as long as we use a JDBC 3.0 driver for Informix
     */
    @Override
    public boolean useInputStreamToInsertBlob() {
        return false;
    }



}