Thread t = new Thread(new Runnable(){

          public void run(){

   while(isDone){  

             //isDone is the boolean variable which will help u end the Thread.

            // SEND THE REQUEST 

try{

  Thread.sleep(5000);   // Delay of 5 seconds before the request is fired again

   }catch(Exception ex){

           ex.printStackTrace();

        }
    }
   }

    });

 t.start();

 t.join();   // Use join() to block the process further till the response arrives.