public class DatabaseClassLoader extends ClassLoader
{
  private DataSource dataSource;

  public DatabaseClassLoader(ClassLoader parent, DataSource dataSource)
  {
    super(parent);
    this.dataSource = dataSource;
  }

  @Override
  public Class<?> loadClass(String name) throws ClassNotFoundException
  {
    byte[] classDefinition = loadClassDefinition(name);

    if (classDefinition != null)
    {
      Class c = defineClass(name, classDefinition, 0, classDefinition.length);
      resolveClass(c);
      return c;
    }
    else
    {
      return super.loadClass(name);
    }
  }

  private byte[] loadClassDefinition(String name)
  {
    ...
  }
}