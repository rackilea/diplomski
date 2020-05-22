Runnable onAnimationStarted=new Runnable() {
            @Override
            public void run() {
            //change ui
            }
        };
Runnable onAnimationStopped=new Runnable() {
            @Override
            public void run() {
            //change ui
            }
        };
       Thread thread = new Thread(){
                @Override
                public void run() {
    runOnUiThread(onAnimationStarted);
              long start= System.currentTimeMillis();;
              while(System.currentTimeMillis()-start<1000) //waits one second
            {

            };
    runOnUiThread(onAnimationStopped);                 
        }

        };
            thread.start();