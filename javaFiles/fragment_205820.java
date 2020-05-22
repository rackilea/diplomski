final Handler handler = new Handler();
Timer timer = new Timer();
TimerTask task = new TimerTask() {       
     @Override
     public void run() {
       handler.post(new Runnable() {
          public void run() {  
             new UploadAsyncTask().execute();
             new DownloadAsyncTask().execute();
          }
        });
      }
};
timer.schedule(task, 0, 1000); //it executes this every 1000ms