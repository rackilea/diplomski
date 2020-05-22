public class WhateverRdbmsConnectionImpl implements java.sql.Connection {

    public java.sql.Statement createStatement() throws java.sql.SQLException {
        WhateverRdbmsStatementImpl stmt = new WhateverRdbmsStatementImpl();
        ...
        return stmt;
    }
}