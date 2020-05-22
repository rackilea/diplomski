public boolean variable = false;
private class MyHandler extends Handler {
    public static final int MESSAGE_TOAST = 1;
    public static final int THREAD_RETURN = 2;

    public void handleMessage(Message msg){
        if(msg.what == MESSAGE_TOAST){
            Toast.makeText(msg.getData().getString("toast"), Toast.LENGTH_LONG).show();
        } else if(msg.what == THREAD_RETURN){
            variable = msg.getData().getBoolean("returnValue");
        }
    }
}
public MyHandler handler = new MyHandler();