class B extends Thread{

public void run(){
      try {
           while(true){ //add here some condition when you want to stop the loop
               A.X++; 
               Thread.sleep(200);
           }
       } catch (InterruptedException e) {
          e.printStackTrace();
      }

   }
}