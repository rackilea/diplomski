Timer _t = new Timer();  
 _t.scheduleAtFixedRate( new TimerTask() {
        @Override
        public void run() {
          //do something
           runOnUiThread(new Runnable() //run on ui thread
             {
              public void run() 
              {      
                //update ui
              }
             });

        }
    }, 1000, 1000 );