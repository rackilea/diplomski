System.setProperty(Context.INITIAL_CONTEXT_FACTORY,
            "com.sun.jndi.fscontext.RefFSContextFactory");
    System.setProperty(Context.PROVIDER_URL, "file:///F:/JNDI/");

    Reference ref = new Reference("javax.sql.DataSource","org.apache.commons.dbcp.BasicDataSourceFactory", null);
    ref.add(new StringRefAddr("driverClassName","com.ibm.db2.jcc.DB2Driver");
    ref.add(new StringRefAddr("url","jdbc:db2://myhost.example.com:port/dbname");
    ref.add(new StringRefAddr("password", "SomePassord");
    ref.add(new StringRefAddr("username", "myUser");

    ref.add(new StringRefAddr("maxActive","100"));
    ref.add(new StringRefAddr("maxWait", "10000"));
    ref.add(new StringRefAddr("maxIdle", "10"));
    ref.add(new StringRefAddr("minIdle", "5"));

    ref.add(new StringRefAddr("testOnBorrow", "true"));
    ref.add(new StringRefAddr("testOnReturn", "false"));
    ref.add(new StringRefAddr("testWhileIdle","true"));
    ref.add(new StringRefAddr("validationQuery","SELECT 1"));

    ref.add(new StringRefAddr("timeBetweenEvictionRunsMillis",Integer.toString(10*60*1000)));
    ref.add(new StringRefAddr("minEvictableIdleTimeMillis",Integer.toString(2*60*1000)));
    ref.add(new StringRefAddr("numTestsPerEvictionRun","10"));

    ref.add(new StringRefAddr("removeAbandoned", "true"));
    ref.add(new StringRefAddr("removeAbandonedTimeout", Integer.toString(30*60)));
    ref.add(new StringRefAddr("logAbandoned", "true"));

    Context ctx = new InitialContext();
    ctx.rebind("jdbc/MyDataSource",ref)
    ctx.close();