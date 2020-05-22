public class DataController {

    ArrayList<String> mConnection_S1;
    ArrayList<String> mConnection_S2;
    ...
    ArrayList<String> mConnection_S2034;

    public DataController() {

        mConnection_S1 = new ArrayList<String>(Arrays.asList("T1"));
        mConnection_S2 = new ArrayList<String>(Arrays.asList("T1", "T2"));
        ...
        mConnection_S2034 = new ArrayList<String>(Arrays.asList("T1", "T2"));
    }
}