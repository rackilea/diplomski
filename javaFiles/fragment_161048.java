public class ThreadingObject {

    private HandlerThread thread;
    private Handler handler;

    private Handler.Callback handlerCallback = new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            work(msg.obj);
            return true;
        }
    };

    public ThreadingObject() {}

    public void onResume() {
        thread = new HandlerThread("SurfaceView HandlerThread");
        thread.start();
        handler = new Handler(thread.getLooper(), handlerCallback);
    }

    public void onPause() {
        if(thread != null) {
            thread.quit();
            thread = null;
        }
        handler = null;
    }

    public void setMessage(Object object) {
        Message msg = new Message();
        msg.obj = object;
        handler.sendMessage(msg);
    }

    protected void work(Object obj) {
        //Working
    }
}