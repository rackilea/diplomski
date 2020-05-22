import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;


    @Inject
    @Named("A")
    protected SqlSession          sessionA;

    @Inject
    @Named("B")
    protected SqlSession          sessionB;