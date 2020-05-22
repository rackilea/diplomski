@Provider
public class FooProvider
    implements InjectableProvider<Resource, Type> {

    public ComponentScope getScope() {
        return ComponentScope.PerRequest;
    }

    public Injectable getInjectable(ComponentContext ic, Resource resource, Type type) {
        return new Injectable() {
            public Object getValue() {
                return new Foo();
            }
        };
    }
}