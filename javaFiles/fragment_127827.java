public class ListModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(ListService.class).to(DummyListService.class);
    }
}