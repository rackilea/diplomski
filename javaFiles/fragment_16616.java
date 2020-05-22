@Component
public class Dependency {

    @Resource
    private NestedDependency nestedDependency;

}


public class Dependency$EnhancerByMockito extends Dependency{
    //...
}