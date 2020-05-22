public class Server{

  public Server(){ //constructor

    Thread client = ClientMethod("Alex");
    System.out.println("i am Client "+client.getName());
  }


  //Make a Thread for a specific Client
  public Thread ClientMethod(String clientName){

     Thread client = new Thread(new Runnable(){
        public void run(){

         //do someWork
        //Then finish

       }//end of run method
     });

    client.setName(clientName); //set the NameOfThread to clientName
    client.start(); //start it

   return client; //return the Thread of this specific Client(as Object)

  }


 //Main Method
  public static void main(String[] args){       
      new Server();                 
  }

}//End of Class [Server]