BTHandler btHandler = new BTHandler(MainActivity.this, new Handler() {
    public void handleMessage(Message msg) {
        String response = msg.getData().getString("message");
        // TODO: take your action here
    }
});