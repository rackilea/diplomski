public class DoSomething implements Runnable {

       private final OnDoneListener listener;

       public DoSomething(OnDoneListener listener){
            this.listener = listener;
       }

       @Override
       public void run(){
            FacebookConnectTask task = ... ;

            task.setOnDoneListener(listener);
       }


}

public class YourActivity extends Activity implements OnDoneListener {

     public void onCreate(Bundle b){
          new Thread(new DoSomething(this)).start();
     }

     @Override
     public void onDone(){
        // Tada
     }

}