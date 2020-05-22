}
....
 // write this outside your code block
 Handler mHandler = new Handler(){
@Override
public void handleMessage(Message msg) {
    super.handleMessage(msg);
    showNotification();
}
};
// call it like this instead of thread start
 mHandler.sendEmptyMessage(0);