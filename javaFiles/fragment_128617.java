@Dependent
public class Parent <T extends SimpleFoo>{

    @Inject
    protected void setFooInstance(Instance<T> instance) {...}
}