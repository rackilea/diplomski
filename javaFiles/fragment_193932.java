public class MyRenderer implements Renderer{

    private Handler handler = null;
    public static final int CALC_FINISHED = 1;

    public void startCalc(Handler handler){
        this.handler = handler;
    }

    public void onDraw(GL10 gl){

        if(handler!=null){
            // do calculation using GL handle
            int flag = MyRenderer.CALC_FINISHED;
            handler.dispatchMessage(Message.obtain(handler, flag));
            // adds a message to the UI thread's message queue

            handler = null;

        }

        // draw

    }

}