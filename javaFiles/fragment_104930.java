Logger.getLogger("org.apache.http.wire").setLevel(Level.FINEST);
Logger.getLogger("org.apache.http.headers").setLevel(FINEST);
Logger.getLogger("httpclient.wire.header").setLevel(FINEST);
Logger.getLogger("httpclient.wire.content").setLevel(FINEST);

System.setProperty("org.apache.commons.logging.Log",
     "org.apache.commons.logging.impl.SimpleLog");
System.setProperty("org.apache.commons.logging.simplelog.showdatetime", "true");
System.setProperty("org.apache.commons.logging.simplelog.log.httpclient.wire", "debug");
System.setProperty("org.apache.commons.logging.simplelog.log.org.apache.http", "debug");
System.setProperty("org.apache.commons.logging.simplelog.log.org.apache.http.headers", "debug");