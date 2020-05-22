@Aspect
@Component
public class MyAspect {

    @DeclareParents(defaultImpl = Guitar.class, value = "com.proxy.SpookerImp")
    private Performer guitar;

}