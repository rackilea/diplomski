dsocket.receive(packet2);
Response = new String(buffer, 0, packet2.getLength());

// we received the response
// but since we are running on a background thread, we can not touch the UI
runOnUiThread(new Runnable() {
    @Override
    public void run() {
        // this is executed on the main (UI) thread
        TextOne.setText(Response);                        }
});

dsocket.close();