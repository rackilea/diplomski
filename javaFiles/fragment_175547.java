public class AbstractClass {
  abstract Logger getLogger();

  public void someMethodInAbstractClass() {
    getLogger().debug("something"); // will output using provided child logger
  }
}

public class ConcreteClass extends AbstractClass {
  private static final Logger LOGGER = Logger.getLogger(ConcreteClass.class);

  @Override
  Logger getLogger() {
    return (LOGGER);
  }

  public void someMethod() {
    getLogger().debug("something"); // will output using local logger
  }
}