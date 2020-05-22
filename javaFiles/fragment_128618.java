@Dependent
public class Child extends Parent<AdvancedFoo> {

    @Override
    protected void setFooInstance(Instance<AdvancedFoo> instance) {...}  
}