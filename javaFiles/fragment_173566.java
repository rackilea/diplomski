public class MyActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstance) {
        // ....
        Handler myHandler = new Handler() {
            @Override
            public void handleMessage (Message msg) {
                doCoolStuffWhenMessageReceived();
            }
        }
        MySecondClass secondClass = new MySecondClass(myHandler);
        // ....
    }
}


public class MySecondClass {
    private handler;
    public MySecondClass(Handler handler){
        this.handler = handler;
    }

    private void someMethodToCallActivity() {
        handler.sendEmptyMessage(0);
    }

}