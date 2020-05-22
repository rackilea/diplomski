Thread timer = new Thread(){
            public void run(){
                try{
                    while (numCompletedDownloads < numDownloadsToExecute) {
                        sleep(100);
                    }
                } catch (InterruptedException e){
                    e.printStackTrace();
                } finally {
                    Intent openMainActivity = new Intent("com.kabe.sample.MAINACTIVITY");
                    startActivity(openMainActivity);
                }
            }
        };