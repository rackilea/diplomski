public interface ServiceFactory
{
  public BaseService create(String uri);
}

public class ServiceFactoryImpl implements ServiceFactory
{
  @Override
  public BaseService create(String uri)
  {
    if(uri.equals("/hello/dispatch"))
      return new HelloServiceImpl();

    else if (uri.equals("/bye/dispatch"))
      return new ByeServiceImpl();

    return null;
  }
}