import java.io.*;
import java.net.*;

public class Client {


public static void main(String[] args){ 

//Portnumber:- number of the port we wish to connect on.
int portNumber = 15882;

//ServerIP:- IP address of the server.
String serverIP = "localhost";

try{
    //Create a new socket for communication
    Socket soc = new Socket(serverIP, portNumber);

    // create new instance of the client writer thread, intialise it and start it running
    ClientWriter clientWrite = new ClientWriter(soc);
    new Thread(clientWrite).start();
    //Shortened code a bit.

    //Thread clientWriteThread = new Thread(clientWrite);
    //clientWriteThread.start();





}
catch (Exception except){
    //Exception thrown (except) when something went wrong, pushing message to the console
    System.out.println("Error --> " + except.getMessage());
}
}}






//This thread is responcible for writing messages
class ClientWriter implements Runnable
 {

 Socket cwSocket = null;

 public ClientWriter (Socket outputSoc){
cwSocket = outputSoc;
 }   


public void run(){
try{
    //Create the outputstream to send data through
    DataOutputStream dataOut = new DataOutputStream(cwSocket.getOutputStream());

    System.out.println("Client writer running");

    //Write message to output stream and send through socket
    dataOut.writeUTF("First");     // writes to output stream
    dataOut.flush();               // sends through socket 

    //close the stream once we are done with it
    //dataOut.close();
        //Closing the stream will close the connection between the server and client.
        //DO NOT close an input stream or output stream when communicating with
        //each other, unless it is one way communication...


   //Where is the listener? It's never called, so we can't listen for anything!
   ClientListener listener = new ClientListener(cwSocket);
   new Thread(listener).start();

}
catch (Exception except){
    //Exception thrown (except) when something went wrong, pushing message to the console
    System.out.println("Error in Writer--> " + except.getMessage());
    except.printStackTrace();
}
 }
}




class ClientListener implements Runnable
{
Socket clSocket = null;

public ClientListener (Socket inputSoc) {
clSocket = inputSoc;
}

public void run() {
try {

    // need to write here to recieve message 
    DataInputStream dataIn = new DataInputStream(clSocket.getInputStream());           // new stuff
    String msg = dataIn.readUTF();
    System.out.print(msg);



}
catch (Exception except){
    //Exception thrown (except) when something went wrong, pushing message to the console
    System.out.println("Error in Writer--> " + except.getMessage());
    except.printStackTrace();
}
  }


}