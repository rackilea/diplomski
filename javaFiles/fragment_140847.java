WARNING - Property "JdbcUsername " not supported by "customDS"
WARNING - Property "JdbcPassword " not supported by "customDS"
WARNING - Property "JdbcUrl " not supported by "customDS"
WARNING - Property "JdbcDriver " not supported by "customDS"

p.put("customDS.JdbcDriver ", "org.hsqldb.jdbc.JDBCDriver");
p.put("customDS.JdbcUrl ", "jdbc:hsqldb:file:target/custom");
p.put("customDS.JdbcUsername ", "sa");
p.put("customDS.JdbcPassword ", "");