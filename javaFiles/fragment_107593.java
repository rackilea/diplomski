Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/XE","klrice","klrice");

//#get a DBUtil but won't actually use it in this example
DBUtil util = DBUtil.getInstance(conn);

//#create sqlcl
ScriptExecutor sqlcl = new ScriptExecutor(conn);
ByteArrayOutputStream bout = new ByteArrayOutputStream();
BufferedOutputStream buf = new BufferedOutputStream(bout);
sqlcl.setOut(buf);

//#setup the context
ScriptRunnerContext ctx = new ScriptRunnerContext();

//#set the context
sqlcl.setScriptRunnerContext(ctx);
ctx.setBaseConnection(conn);

//#change the format
sqlcl.setStmt("set sqlformat insert");
sqlcl.run();

//#run the sql
sqlcl.setStmt("select * from user_objects");
sqlcl.run();

String results = bout.toString("UTF8");
System.out.println(results);