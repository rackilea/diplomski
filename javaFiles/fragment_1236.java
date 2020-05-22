public class Driver extends Application{

  //create socket handlers
  Runnable myNewThread = new workerThread(this, this.getClass());

 //variables
 private String lastMessage = "";

 //getters and setters
 public String setMyVariable() {
   this.MyVariable = MyVariable;
 }

 //main
 public static void main(String[] args) {
   //launch threads
   new Thread(new Driver().myNewThread).start();
 }
}