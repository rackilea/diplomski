@Test
public void testGet() throws Exception
{
    // Create Server
    Server server = new Server(8080);
    ServletContextHandler context = new ServletContextHandler();
    ServletHolder defaultServ = new ServletHolder("default", DefaultServlet.class);
    defaultServ.setInitParameter("resourceBase",System.getProperty("user.dir"));
    defaultServ.setInitParameter("dirAllowed","true");
    context.addServlet(defaultServ,"/");
    server.setHandler(context);

    // Start Server
    server.start();

    // Test GET
    HttpURLConnection http = (HttpURLConnection)new URL("http://localhost:8080/").openConnection();
    http.connect();
    assertThat("Response Code", http.getResponseCode(), is(HttpStatus.OK_200));

    // Stop Server
    server.stop();
}