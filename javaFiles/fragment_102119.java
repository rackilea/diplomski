public class ClientFactoryImpl implements ClientFactory {
    private static final EventBus eventBus = new SimpleEventBus();
    /* The views */
    private static final SampleView sampleView = new SampleView(); 
    ....

    public ClientFactoryImpl(){
        eventBus.addHandler(ReleaseAddedEvent.type, sampleView);
        ....
    }


    // getter and setters
}