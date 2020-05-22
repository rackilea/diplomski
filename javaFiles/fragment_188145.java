public class MyModule extends AbstractModule {

  @Override
  protected void configure() {
    try {
        Properties properties = new Properties();
        properties.load(new FileReader("my.properties"));
        Names.bindProperties(binder(), properties);
    } catch (IOException ex) {
        //...
    }
  }
}