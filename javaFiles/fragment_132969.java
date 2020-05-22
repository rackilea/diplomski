public class MyModule1
{
  public static void contributeRegistryStartup(OrderedConfiguration<Runnable> configuration)
  {
    configuration.add("MyFirstContribution", new Runnable() { ... });
  }
}

public class MyModule2
{
  public static void contributeRegistryStartup(OrderedConfiguration<Runnable> configuration)
  {
    configuration.add("MySecondContribution", new Runnable() { ... }, "after:MyFirstContribution");
  }
}