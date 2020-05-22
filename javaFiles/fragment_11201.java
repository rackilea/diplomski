public class YourClass implements OnDoneListener {

    public doFacebook(){

      new Thread(new Runnable(){
         @Override
         public void run(){
              task.setOnDoneListener(YourClass.this);
         }
      }.start();

    }


    @Override
    public void onDone(){

    }

}