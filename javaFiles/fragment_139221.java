List<Object> list = ...
...
Object[] array = list.toArray();
oracle.jdbc.OracleDriver ora = new oracle.jdbc.OracleDriver();
java.sql.Connection conn = ora.defaultConnection();
oracle.jdbc.OracleConnection oraConn = (oracle.jdbc.OracleConnection) conn;
java.sql.Array sqlArray = oraConn.createARRAY("typeName", array);