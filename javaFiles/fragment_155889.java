private Handler handler;
 private Runnable runnable;


  handler = new Handler();
                handler.postDelayed(runnable, 1000);
                runnable = new Runnable() {
                    @Override
                    public void run() {
                        try{
                            System.out.println(" show me current location " + getlocationcoordinate(getApplicationContext()));
                        }
                        catch(Exception e){
                            e.printStackTrace();
                        }
                        handler.postDelayed(this, 1000); //start again
                    }
                };