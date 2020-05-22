public class MyRunnable implements Runnable {
    private Handler h2;
    public MyRunnable(Handler h) {
        this.h2 = h;
    }

    @Override
    public void run() {

        //everything inside rum method executes in new thread
        for(int i=0;i<10;i++) {
            Message m = Message.obtain(); //get null message
            Bundle b = new Bundle();
            b.putString("udd", "daju");
            m.setData(b);
            //use the handler to send message
            h2.sendMessage(m);

        }
    }
}