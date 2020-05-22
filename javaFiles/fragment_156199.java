class ServiceException extends Exception {
  public ServiceException(String msg) {
    super(msg);
  }
}

interface MyService {
  String sayHello(Object who) throws ServiceException;

  void throwIt() throws ServiceException;
}

class MyServiceImpl implements MyService {

  @Override
  public String sayHello(Object who) throws ServiceException {
    String hello = who.toString();
    System.out.println("Server said: " + hello);
    return "Hello! " + hello;
  }

  @Override
  public void throwIt() throws ServiceException {
    throw new ServiceException("throw in server");
  }
}