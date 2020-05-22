public class MyReadingProcessing implements Runnable{

     public void run(){
          while (true){
               readFile(...);
               try{
                  Thread.sleep(1000); // 1 second here but choose the deemed reasonable time according the metrics of your producer application
               }  
               catch(InterruptedException e){
                  Thread.currentThread().interrupt();
               }
               if (isAllReadFile()){ // condition to stop the reading process
                   return;
               }
          }
     }
}