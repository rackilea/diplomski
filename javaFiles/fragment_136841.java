URL tomcatUrl = new URL("http://localhost:18080/ppi/jobperform/headertest")//tomcat;
URLConnection tconnect = tomcatUrl.openConnection();
System.out.println("tomcat: " + tconnect.getContentType());


URL jettyUrl = new URL("http://localhost:13818/ppi/jobperform/headertest")//jetty;
URLConnection jconnect = jettyUrl.openConnection();
System.out.println("jetty: " + jconnect.getContentType());