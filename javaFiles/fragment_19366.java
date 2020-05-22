public DataController() {

    ArrayList<String> lConnection_S1 = new ArrayList<String>(Arrays.asList("T1"));
    ArrayList<String> lConnection_S2 = new ArrayList<String>(Arrays.asList("T1", "T2"));
    ...
    ArrayList<String> lConnection_S2034 = new ArrayList<String>(Arrays.asList("T1", "T2"));

    mTram1Stations = new ArrayList<StationItem>(Arrays.asList(
        new StationItem("Station 1","T1",0,0,lConnection_S1),
        new StationItem("Station 2","T1",0,0,lConnection_S2)
    ));

    mBus1Stations = new ArrayList<StationItem>(Arrays.asList(
        new StationItem("Station 1","B1",0,0,lConnection_S1),
        new StationItem("Station 2","B1",0,0,lConnection_S2)
    ));

    mTram1Locations = new ArrayList<LatLng>(Arrays.asList(
        new LatLng(40.190, 3.20),
        new LatLng(40.191, 3.21),
        new LatLng(40.192, 3.22)
    ));
}