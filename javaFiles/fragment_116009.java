public void wait3s()
{
     t.schedule(new TimerTask() {
         @Override
        public void run() {
             runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    startStop();
                }
            });
        }
    }, 3000);
}