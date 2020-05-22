@Bean
public ServletRegistrationBean deleteUserServlet(DBJointPool db) {
    // suppose there is a constructor for your servlet
    final ServletRegistrationBean servlet = new ServletRegistrationBean(new DeleteUserServlet(db));
    servlet.setName("deleteUserServlet");
    servlet.setUrlMappings(Collections.singletonList("/deleteUser.*"));
    return servlet;
}