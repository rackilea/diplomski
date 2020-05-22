@Module public interface ActionModule {
  @Binds @IntoMap @ClassKey(ConcreteAction1.class)
  IAction bindActionClass1(ConcreteAction1 action1);

  @Binds @IntoMap @ClassKey(ConcreteAction2.class)
  IAction bindActionClass2(ConcreteAction2 action2);

  // ...

  @Binds @IntoMap @StringKey("name_1")
  IAction bindActionName1(ConcreteAction1 action1);

  @Binds @IntoMap @StringKey("name_2")
  IAction bindActionName2(ConcreteAction2 action2);

  // ...
}

public class ActionFactory implements IActionFactory{
  @Inject Map<Class<?>, Provider<IAction>> classActionFactory;
  @Inject Map<String, Provider<IAction>> stringActionFactory;

  @Override
  public IAction createByClass(Class<?> clazz) {
    // TODO: handle missing entries gracefully
    return classActionFactory.get(clazz).get();
  }

  @Override
  public IAction createByName(String name) {
    return stringActionFactory.get(name).get();
  }
}