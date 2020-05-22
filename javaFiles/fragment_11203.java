public class DoSomething implements Runnable, OnDoneListener {

       public interface OnFacebookFinished {
              void onFacebookFinished();
       }

       private final OnFacebookFinished listener;

       public DoSomething(OnFacebookFinished listener){
            this.listener = listener;
       }

       @Override
       public void run(){
            FacebookConnectTask task = ... ;

            task.setOnDoneListener(this);
       }

       @Override
       public void onDone(){
           if(listener != null){
               listener.onFacebookFinished();
           }
       }


}

public class YourActivity extends Activity implements OnFacebookFinished {

     @Override
     public void onCreate(Bundle b){
          new Thread(new DoSomething(this)).start();
     }

     @Override
     public void onFacebookFinished(){
        // Tada
     }

}