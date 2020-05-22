Use this:
//Declare globally

Handler handler = new Handler();
    Runnable runnable;

//then whereever you want to call your url
runnable = new Runnable() {
            @Override
            public void run() {
                new AsyncParam().execute("http://10.0.2.2:88/API/web/app_dev.php/get/1/7");
//this will call your url after every one sec
                handler.postDelayed(runnable,1000);
            }
        };
//in place of 1000 provide initial delay you can give 0 also if you want to call immediately
        handler.postDelayed(runnable,1000);