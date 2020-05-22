private class MyHandlerThread extends HandlerThread { 

Handler handler;

public MyHandlerThread(String name)
 { 
super(name); 
} 
@Override 
protected void onLooperPrepared() { 
handler = new Handler(getLooper()) { 
@Override 
public void handleMessage(Message msg) {
 // process incoming messages here 
// this will run in non-ui/background thread
 } 
}; 
} 
}