Connection con = sessionFactory.getSessionFactoryOptions().getServiceRegistry().getService(ConnectionProvider.class).getConnection();
BufferedReader in = new BufferedReader(new FileReader("sample_script.sql"));
LineNumberReader fileReader = new LineNumberReader(in);
String query = ScriptUtils.readScript(fileReader, ScriptUtils.DEFAULT_COMMENT_PREFIX, ScriptUtils.DEFAULT_STATEMENT_SEPARATOR);
Statement stmt = null;
stmt = con.createStatement();
stmt.execute(query);