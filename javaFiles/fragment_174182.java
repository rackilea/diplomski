public class B  
{
    @Inject
    Provider<A> a;

    public void doSomeActionWithToPass() {
        String toPass = a.get().getToPass());
        ...
    }