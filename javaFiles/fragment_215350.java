// Your custom entity listener.
@Slf4j
public class MyMapEventLogger implements EntryAddedListener<String, String>,
        EntryRemovedListener<String, String>, EntryUpdatedListener<String, String>,
        EntryEvictedListener<String, String>, MapEvictedListener, MapClearedListener {

    @Override
    public void entryAdded(EntryEvent<String, String> event) {
        log.info("entryAdded: {}" , event);
    }

    @Override
    public void entryRemoved(EntryEvent<String, String> event) {
        log.info("entryRemoved: {}", event);
    }

    @Override
    public void entryUpdated(EntryEvent<String, String> event) {
        log.info("entryUpdated: {}", event);
    }

    @Override
    public void entryEvicted(EntryEvent<String, String> event) {
        log.info("entryEvicted: {}", event);
    }

    @Override
    public void mapEvicted(MapEvent event) {
        log.info("mapEvicted: {}", event);
    }

    @Override
    public void mapCleared(MapEvent event) {
        log.info("mapCleared: {}", event);
    }
}