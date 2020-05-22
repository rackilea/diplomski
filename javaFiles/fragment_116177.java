timer = new CountDownTimer(11000, 1000) 
        {
           public void onTick(long millisUntilFinished) 
           {
             global.toast.setText("No Internet Connection!" + "\n" + "Automatic Refresh In: " + millisUntilFinished / 1000); //set text for toast
             global.toast.show(); //show toast
           }

           public void onFinish() 
           {
              if (network_connected == false) 
              {
                 global.cancel_toast(0); //stop all toasts
                 finish(); //quit activity
                 startActivity(new Intent(main_activity.this, main_activity.class)); //start activity
              }
              else 
              {
              }
          }
      }.start(); //start the countdowntimer
}