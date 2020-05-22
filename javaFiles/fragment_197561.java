public class Aggregator {
    private EventBus eventBus = new EventBus();

    public void register(Object obj) {
        eventBus.register(obj);
    }

    public void dispatch(News news) {
        eventBus.dispatch(news);
    }
}