package com.test.rest.controller;

import com.fasterxml.jackson.annotation.JsonInclude;
import ........    

public class TestAppController {

@Test
public void testController() throws Exception {

    Server mockServer = new Server(9190);
    startMockServer("query-rs-main.xml", "query-rs", mockServer);

    EAApplication requestEntity = new EAApplication();
    Application application = new Application();
    application.setDietaryRestrictions("Cheese only");
    application.setFirstName("Mickey");
    application.setLastName("Mouse");
    application.setEmail("mm@disney.com");
    application.setJsonSchemaSkillLevel("Expert");
    application.setRestSkillLevel("Novice");
    application.setSubmissionDate(new Date());
    application.setOdataLibFamiliarity(true);
    application.setRestStandardFamiliarity(true);

    List<Application> list = new ArrayList<>();
    list.add(application);

    requestEntity.setApplications(list);

    RestTemplate template = new RestTemplate();

    List<HttpMessageConverter<?>> converters = new ArrayList<HttpMessageConverter<?>>();
    MappingJackson2HttpMessageConverter mappingJacksonHttpMessageConverter = new MappingJackson2HttpMessageConverter();
    ObjectMapper objectMapper = new ObjectMapper();
    objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
    objectMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
    mappingJacksonHttpMessageConverter.setObjectMapper(objectMapper);
    mappingJacksonHttpMessageConverter.setPrettyPrint(true);
    converters.add(mappingJacksonHttpMessageConverter);
    template.setMessageConverters(converters);

    ResponseEntity<EAApplication> response = template.postForEntity(
            "http://localhost:9190/query-rs/eaapps",
            requestEntity, EAApplication.class);

    mockServer.stop();

}

public static void startMockServer(final String mainAppContextConfig, final String contextRoot, Server server) throws Exception {
    final DispatcherServlet servlet = new DispatcherServlet();
    servlet.setContextConfigLocation("classpath:" + mainAppContextConfig);
    final ServletHolder servletHolder = new ServletHolder(servlet);

    final ServletContextHandler context = new ServletContextHandler();
    context.setErrorHandler(null);
    context.setContextPath("/" + contextRoot);
    context.addServlet(servletHolder, "/*");

    server.setHandler(context);
    server.start();
}


}