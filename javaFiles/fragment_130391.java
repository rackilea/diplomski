package my.package;

import com.sun.jersey.spi.container.ContainerRequest;
import com.sun.jersey.spi.container.ContainerResponse;
import com.sun.jersey.spi.container.ContainerResponseFilter;

public class SimpleFilter implements ContainerResponseFilter
{
  private static final String HEADER = "MyHeader";

  public SimpleFilter()
  {
  }

  @Override
  public ContainerResponse filter(final ContainerRequest request, final ContainerResponse response)
  {
    response.getHttpHeaders().add(HEADER, "MyValue");
    return response;
  }
}