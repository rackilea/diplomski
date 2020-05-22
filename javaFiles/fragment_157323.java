public abstract class AbstractFoo {
    protected final Log log = LogFactory.getLog(getClass());

    ...
}

public class Foo extends AbstractFoo {
    public void someMethod() {
        log.info("Using abstract log");
    }
}