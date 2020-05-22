public class ClientThread implements Runnable {
private Socket clientSocket = null;
ClientThread(Socket s){
    this.clientSocket= s; 
    //give this thead a unique identifier like a name using this.setName() method
}
void sendMessage(){
    for (ClientThread c : DBServer.users) {
        if(c.getName().equals(/*Name of thread you want to contact*/)){
            //send message here
        }
    }
}
}