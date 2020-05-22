ModelImpl m = new ModelImpl()
          .description("LocalDateTime in ISO format")
          .format("ISO DateTime")
          .name("DateTime")
          .type("string");
Response response = getListingJsonResponse(app, context, sc, headers, uriInfo);
Swagger swagger = (Swagger) response.getEntity();
swagger.getDefinitions().put("LocalDateTime", m);