Thread thread = new Thread() {
   public void run() {
       mqttClient.publish(topic, message);
   }  
};
thread.start();