class OrderBean {
   @FormDataParam("clientName")
    private String clientName;
  // getter/setters
  }

@POST
  public Response post(@BeanParam OrderBean order) {}