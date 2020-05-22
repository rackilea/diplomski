@Override
public void onNotificationPosted(StatusBarNotification sbn) {   
    new Thread(new Runnable() {             
            public void run(){
            Looper.prepare();
            int cangethtml = 1;
                try{
                    if(cangethtml==1){
                        cangethtml = 0; //only runs once
                        new html(NLService.this); --> !!!! inject CONTEXT !!!!
                    }
                }finally{Looper.loop();}  
            }; 
        }).start();    
    }