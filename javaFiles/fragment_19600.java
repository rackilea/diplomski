public class Connection {

    private       static Connection          connInst;
    private       static boolean             connected;

    private       static MqttAndroidClient   mqttAndroidClient;
    private       static IMqttActionListener mqttActionListener;
    private final static MqttConnectOptions  mqttConnectOptions = new MqttConnectOptions (); 
    static {
        mqttConnectOptions.setMqttVersion (MqttConnectOptions.MQTT_VERSION_3_1_1);
        mqttConnectOptions.setAutomaticReconnect (true);
        mqttConnectOptions.setCleanSession (false);
    }

    private Connection (Context context) {
        //Instantiate the mqtt android client class
        mqttAndroidClient = new MqttAndroidClient (context.getApplicationContext (), serverUri, clientId);

        mqttAndroidClient.setCallback (new MqttCallbackExtended () {

            @Override
            public void connectComplete (boolean reconnect, String serverURI) {
                connected = true;
                if (reconnect) {
                    System.out.println ("Reconnected to : " + serverURI);
                } else {
                    System.out.println ("Connected to: " + serverURI);
                }
            }

            @Override
            public void connectionLost (Throwable cause) {
                connected = false;
                System.out.println ("The Connection was lost.");
            }

            @Override
            public void messageArrived (String topic, final MqttMessage message) throws Exception {
                System.out.println ("Message received and Arrived");
            }

            @Override
            public void deliveryComplete (IMqttDeliveryToken token) {
                System.out.println("Message Delivered");
            }
        });

        mqttActionListener = new IMqttActionListener () {

            @Override
            public void onSuccess (IMqttToken asyncActionToken) {
                System.out.println ("BROKER CONNECTED");

                DisconnectedBufferOptions disconnectedBufferOptions = new DisconnectedBufferOptions ();
                disconnectedBufferOptions.setBufferEnabled (true);
                disconnectedBufferOptions.setBufferSize (100);
                disconnectedBufferOptions.setPersistBuffer (false);
                disconnectedBufferOptions.setDeleteOldestMessages (false);

                //mqttAndroidClient.setBufferOpts (disconnectedBufferOptions);

            }

            @Override
            public void onFailure (IMqttToken asyncActionToken, Throwable exception) {
                System.out.println ("Failed to connect to: " + serverUri);
            }
        });
    }

    public static Connection getInstance (Context context) {
        if (connInst == null) {
            connInst = new Connection (context);
        }
        createConnectionIfNeeded (context);

        return connInst;
    }

    private static void createConnectionIfNeeded () {
        if (connected) {
            return;
        }

        try {
            mqttAndroidClient.connect (mqttConnectOptions, null, mqttActionListener);

        } catch (MqttException ex) {
            ex.printStackTrace ();
        }
    }

    // ...
}