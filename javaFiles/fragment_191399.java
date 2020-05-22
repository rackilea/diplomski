jerseyServlet.setInitParameter(ServerProperties.PROVIDER_CLASSNAMES,
      "com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider");

jerseyServlet.setInitParameter(ServerProperties.PROVIDER_PACKAGES, 
      "jersey.jetty.embedded"  // my package(s)
);