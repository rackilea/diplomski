public static final String HOST = "208.68.163.218"; //write your host name
public static final int PORT = 5222;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    connect();
}

public void connect() {
    Thread t = new Thread(new Runnable() {

        @Override
        public void run() {
            Context context = getApplicationContext();
            SmackAndroid.init(context);
            ConnectionConfiguration ConnectionConfiguration = new ConnectionConfiguration(HOST, PORT);
            ConnectionConfiguration.setDebuggerEnabled(true);
            XMPPConnection connection = new XMPPTCPConnection(ConnectionConfiguration);     

            try {
                connection.connect();
            } catch (ConnectionException e) {
                e.printStackTrace();
            } catch (SmackException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (XMPPException e) {
                e.printStackTrace();
            }
        }
    });
    t.start();
}