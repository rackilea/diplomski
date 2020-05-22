Handler handler=new Handler();
 handler.post(new Runnable(){

        @Override
        public void run() {

             // upadte textView here

            handler.postDelayed(this,500); // set time here to refresh textView

        }

    });