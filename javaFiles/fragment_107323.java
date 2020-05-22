@Singleton
public class RoomsCached {

    @Inject
    Rooms rooms;

    private List<Room> cachedRooms; 
    private long timeout = 86400000L; // reload once a day
    private long lastUpdate;    


    public List<Room> getCachedRooms() {
        initCache();
        return cachedRooms;
    }

    public void initCache() {
        if (cachedRooms == null || expired()) {
            cachedRooms = Collections.unmodifiableList(rooms.findAll());
            lastUpdate  = System.currentTimeMillis();
        }
    }        

    private boolean expired() { 
        return System.currentTimeMillis() > lastUpdate + timeout; 
    }

}