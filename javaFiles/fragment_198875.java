import javax.inject.Inject;
import org.glassfish.hk2.api.Factory;
import org.glassfish.hk2.api.ServiceLocator;
import org.springframework.context.ApplicationContext;

public class MyRepositoryFactory implements Factory<MyRepository> {

    private final MyRepository repo;

    @Inject
    public MyRepositoryFactory(ApplicationContext ctx, ServiceLocator locator) {
        MyRepository r = ctx.getBean(MyRepository.class);
        locator.inject(r);
        this.repo = r;
    }


    @Override
    public MyRepository provide() {
        return repo;
    }

    @Override
    public void dispose(MyRepository t) {/* noop */}
}