@Bean
public ServletRegistrationBean addUserServlet(DBJointPool db) {
    // suppose there is a constructor for your servlet
    final ServletRegistrationBean servlet = new ServletRegistrationBean(new AddUserServlet(db));
    servlet.setName("addUserServlet");
    servlet.setUrlMappings(Collections.singletonList("/addUser.*"));
    return servlet;
}