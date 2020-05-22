public Emitter.Listener onConnectEvent = new Emitter.Listener() {
    @Override
    public void call(Object... args) {
         JSONObject data = (JSONObject) args[0];
         String deviceId = data.getString("DeviceID");
         map.put(deviceId, new Path());
    }
};