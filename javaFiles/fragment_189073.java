[info] Starting scala interpreter...
[info] 
Welcome to Scala version 2.11.5 (Java HotSpot(TM) 64-Bit Server VM, Java 1.8.0_31).
Type in expressions to have them evaluated.
Type :help for more information.

scala> import com.mchange.v2.c3p0._
import com.mchange.v2.c3p0._

scala> val cpds = new ComboPooledDataSource()
Jul 08, 2016 1:44:43 PM com.mchange.v2.log.MLog 
INFO: MLog clients using java 1.4+ standard logging.
Jul 08, 2016 1:44:43 PM com.mchange.v2.c3p0.C3P0Registry 
INFO: Initializing c3p0-0.9.5.2 [built 08-December-2015 22:06:04 -0800; debug? true; trace: 10]
cpds: com.mchange.v2.c3p0.ComboPooledDataSource = com.mchange.v2.c3p0.ComboPooledDataSource[ identityToken -> 2u6yea9h1khti8o11c1oj2|2407f8d8, dataSourceName -> 2u6yea9h1khti8o11c1oj2|2407f8d8 ]

scala> cpds.setUser("root")

scala> cpds.setJdbcUrl("jdbc:mysql://localhost/test?useSSL=false&serverTimezone=UTC")

scala> val conn = cpds.getConnection()
Jul 08, 2016 1:45:03 PM com.mchange.v2.c3p0.impl.AbstractPoolBackedDataSource 
INFO: Initializing c3p0 pool... com.mchange.v2.c3p0.ComboPooledDataSource [ acquireIncrement -> 3, acquireRetryAttempts -> 30, acquireRetryDelay -> 1000, autoCommitOnClose -> false, automaticTestTable -> null, breakAfterAcquireFailure -> false, checkoutTimeout -> 0, connectionCustomizerClassName -> null, connectionTesterClassName -> com.mchange.v2.c3p0.impl.DefaultConnectionTester, contextClassLoaderSource -> caller, dataSourceName -> 2u6yea9h1khti8o11c1oj2|2407f8d8, debugUnreturnedConnectionStackTraces -> false, description -> null, driverClass -> null, extensions -> {timezone=HKT}, factoryClassLocation -> null, forceIgnoreUnresolvedTransactions -> false, forceSynchronousCheckins -> false, forceUseNamedDriverClass -> false, identityToken -> 2u6yea9h1khti8o11c1oj2|2407f8d8, idleConnectionTestPeriod -> 0, initialPoolSize -> 3, jdbcUrl -> jdbc:mysql://localhost/test?useSSL=false&serverTimezone=UTC, maxAdministrativeTaskTime -> 0, maxConnectionAge -> 0, maxIdleTime -> 0, maxIdleTimeExcessConnections -> 0, maxPoolSize -> 15, maxStatements -> 0, maxStatementsPerConnection -> 0, minPoolSize -> 3, numHelperThreads -> 3, preferredTestQuery -> null, privilegeSpawnedThreads -> false, properties -> {user=******}, propertyCycle -> 0, statementCacheNumDeferredCloseThreads -> 0, testConnectionOnCheckin -> false, testConnectionOnCheckout -> false, unreturnedConnectionTimeout -> 0, userOverrides -> {}, usesTraditionalReflectiveProxies -> false ]
conn: java.sql.Connection = com.mchange.v2.c3p0.impl.NewProxyConnection@6044a933 [wrapping: com.mysql.cj.jdbc.ConnectionImpl@4318f07b]

scala> val proxyStatement = conn.createStatement()
proxyStatement: java.sql.Statement = com.mchange.v2.c3p0.impl.NewProxyStatement@57b482ea [wrapping: com.mysql.cj.jdbc.StatementImpl@b120337]

scala> val nativeStmt = proxyStatement.unwrap(classOf[com.mysql.cj.jdbc.StatementImpl])
nativeStmt: com.mysql.cj.jdbc.StatementImpl = com.mysql.cj.jdbc.StatementImpl@b120337