@Component(modules = ModuleA.class) public interface ComponentA {
  BindingOne bindingOne();
}

@Module public abstract class ModuleA {
  @Provides static BindingOne getBindingOne() { return BindingOne.INSTANCE; }
  @Provides static BindingTwo getBindingTwo() { return BindingTwo.INSTANCE; }
}

// ComponentB has access to BindingOne but not BindingTwo, because it can only see
// what is available in ComponentA, not ComponentA's module set that includes ModuleA.
@Component(dependencies = ComponentA.class) public interface ComponentB { /* ... *}