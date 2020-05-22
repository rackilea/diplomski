public class TripController extends GenericForwardComposer {

    private final TripSessionManager tripSessionManager;

    public TripController() {
        // ZK calls the default constructor
        this(new ZKTripSessionManager());
    }

    protected TripController(TripSessionManager tripSessionManager) {
        this.tripSessionManager = tripSessionManager;
    }

    public void onClick$getTrips(Event event) throws Exception {
        tripSessionManager.setTo(to.getValue());
        tripSessionManager.setFrom(from.getValue());
    }

}