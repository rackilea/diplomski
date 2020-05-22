boolean retrying = false;
   public void reConnect(){
        if (!retrying) {
            retrying = true;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (;;) {
                        try {
                            if (isInetAvailable() && !mqttClient.isConnected()) {
                                if(isPasswdProtected) {
                                     //connect with MqttConnectionOptions
                                    Connect_with_passwd();
                                } else {
                                    Connect();
                                }
                                Thread.sleep(MQTT_RETRY_INTERVAL);
                            } else if (isConnected()) {
                                List<String> topics = topicsSubscribed;
                                topicsSubscribed.clear();
                                for (String topic : topics) {
                                    try {
                                        subscribeToTopic(topic);
                                    } catch (MqttException e) {
                                    }
                                }
                                retrying = false;
                                break;
                            } else if (!Internet.isAvailable()) {
                                Thread.sleep(INET_RETRY_INTERVEL);
                            }
                        } catch (MqttException | InterruptedException e) {
                            try {
                                Thread.sleep(MQTT_RETRY_INTERVAL);
                            } catch (InterruptedException ex) {
                            }
                        }
                    }
                }
            }).start();
        }
}
 /*Check internet connection*/

 public static boolean isInetAvailable() {
    boolean connectivity;
    try {
        URL url = new URL(GOOGLE);
        URLConnection conn = url.openConnection();
        conn.connect();
        connectivity = true;
    } catch (IOException e) {
        connectivity = false;
    }
    return connectivity;
}