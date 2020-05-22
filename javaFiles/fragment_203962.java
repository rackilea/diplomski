new Thread(new Runnable(){

   public void run(){

    try{
          while (true){

        Thread.sleep(60000);
        yahoo() // CALL TO YAHOO SENSEX 

        repaint();
          }
       }catch(Exception ex){

         }
 }).start();