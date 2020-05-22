public class GuiceTestModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(Integer.class)
        .annotatedWith(Names.named("fancy"))
        .toInstance(10);
    }

    @Provides
    FancyEmailService fancyEmailServiceProvider(@Named("fancy") int i){
        return new FancyEmailService(i);
    }

}