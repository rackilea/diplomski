public interface EventRepositoryCustom {

    Page<Event> findEvent();

}

public interface EventRepository extends EventRepositoryCustom, SolrCrudRepository<Event, String> {

}

public class EventRepositoryImpl implements EventRepositoryCustom {

    private SolrTemplate eventTemplate;

    public EventRepositoryImpl(SolrTemplate eventTemplate) {
        this.eventTemplate = eventTemplate;
    }

    @Override
    public Page<Event> findEvent() {
        return eventTemplate.queryForPage(new SimpleQuery("*:*"), Event.class);
    }

}