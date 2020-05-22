public class YourActivity extends Activity {
   // Declare the variable to be accessed later.
   CountDownTimer t;

   ...

   public void startTimer(final long finish, long tick) {
     t = new CountDownTimer(finish, tick) {
         ...
     }.start();

   }


   private void yourOtherMethod() {

    floatingWindow.findViewById(R.id.btn_deny).setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View view) {
          if(t != null) t.cancel();
          ...
       }
    });
   }

}