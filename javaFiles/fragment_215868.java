class MyWorker extends SwingWorker<Void, Void> {
    // properties to listen for changes to:
    public static final String LISTEN_STATE = "listen state";
    public static final String CURRENT_PORT_ID = "current port id";
    public static final String DATA_FEED = "data feed";
    private String listenState = "None";
    private String dataFeed = "";
    private String currentPortId = "";

    @Override
    protected Void doInBackground() throws Exception {
        while (true) {
            if (Serial.currPortId != (null)) {
                // change properties when data comes in
                String currPortId = Serial.currPortId.getName();
                setListenState(currPortId);
                setCurrentPortId(currPortId);
                setDataFeed(ImportMenu.serialImport.datafeed);
            } else {
                setListenState("None");
                break; // ??
            }
        }
        return null;
    }

    public String getListenState() {
        return listenState;
    }

    public void setListenState(String listenState) {
        // set the prop change parameters
        String oldValue = this.listenState;
        String newValue = listenState;

        // update the propertie's state
        this.listenState = listenState;

        // notify listeners of the change
        firePropertyChange(LISTEN_STATE, oldValue, newValue);
    }

    public String getDataFeed() {
        return dataFeed;
    }

    public void setDataFeed(String dataFeed) {
        // same rationale as for the other setter method
        String oldValue = this.dataFeed;
        String newValue = dataFeed;
        this.dataFeed = dataFeed;
        firePropertyChange(DATA_FEED, oldValue, newValue);
    }

    public String getCurrentPortId() {
        return currentPortId;
    }

    public void setCurrentPortId(String currentPortId) {
        // same rationale as for the other setter method
        String oldValue = this.currentPortId;
        String newValue = currentPortId;
        this.currentPortId = currentPortId;
        firePropertyChange(CURRENT_PORT_ID, oldValue, newValue);
    }
}