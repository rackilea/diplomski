try{
                for(int s=0;s<=100;s++)
                {

                    s=s+20;
                    sleep(1000);
                    progressbar.setProgress(s);
                }
            }catch(InterruptedException e){
                e.printStackTrace();
            }finally{
               //do some thing after you finish thread
            }
        }
    };
    background.start();