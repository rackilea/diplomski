@BeforeClass
public static void initServletContainer() throws Exception {
    tester = new ServletTester();
    tester.setContextPath("/");
    tester.addServlet(DummyServlet.class, "/dummy");
    baseUrl = tester.createSocketConnector(true);
    tester.start();
    System.out.println(baseUrl);
}