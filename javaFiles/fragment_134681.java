public class MyFilter extends com.sun.jersey.api.container.filter.LoggingFilter {

// other (maybe fundamental) code omitted for brevity

  @Override
  public ContainerRequest filter(ContainerRequest request) {
      if(!request.getMethod().equals("GET")) {
          return super.filter(request);   
      }
      return request;
  }

}