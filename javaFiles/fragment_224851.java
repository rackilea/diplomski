public class Consumer implements Runnable {

     long myId;

     Consumer(long id){
       myId = id;
     }

     public void run() {
        data = get data from db for the id
        // do whatever a consumer does with data
     }
 }