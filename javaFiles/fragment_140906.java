while(true){
        Thread myThread = new Thread(new Runnable() {

                 public void run()
                       {


                          try 
                           {
                    synchronized (this) { 
                         X = (double) Float.parseFloat(Splited2[textIndex]);
                         Y = (double) Float.parseFloat(Splited2[textIndex+1]);
                         Z = (double) Float.parseFloat(Splited2[textIndex+2]);
                         textIndex+=3;
                            locations = algo(X,Y,Z,pitch_angle, roll_angle,
                                        azimuth_angle);

                         }

                           } 
                           catch (Exception e) 
                           {
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                            } 
                       }
                        });
myThread.start();
myThread.join();
}