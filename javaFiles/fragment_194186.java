import java.io.*;
import java.net.*;

public class Serv {

//Main Method:- called when running the class file.
public static void main(String[] args){ 

//Portnumber:- number of the port we wish to connect on.
int portNumber = 15882;
try{
    //Setup the socket for communication 
    ServerSocket serverSoc = new ServerSocket(portNumber);

    while (true){
        //accept incoming communication
        System.out.println("Waiting for client");
        Socket soc = serverSoc.accept();

        /* It's best to initialize both the input and output streams at the same time
         * Make sure you read what the other stream said before writing to it,
         * or it can be a cluttered error causing mess.
        */

        DataOutputStream dos = new DataOutputStream(soc.getOutputStream());
        DataInputStream dataIn = new DataInputStream(soc.getInputStream());



        //Read what client sent us
        System.out.println("Message Received: -->" + dataIn.readUTF());

        //Send reply back to client
        dos.writeUTF("Message Recieved");    // new stuff
        dos.flush();                         //need to flush


        //Close the inputstream and output stream so we can disconnect this user
        //and wait for another one to connect.
        dataIn.close();
        dos.close();


        //Can not read after writing back, doesn't make sense

        //create a new thread for the connection and start it.
        //ServerConnetionHandler sch = new ServerConnetionHandler(soc);
        //Thread schThread = new Thread(sch);
        //schThread.start();
    }
}
catch (Exception except){
    //Exception thrown (except) when something went wrong, pushing message to the console
    System.out.println("Error --> " + except.getMessage());
    except.printStackTrace();
}
}}



/*The last code you had was all wrong. Up in the server, you were
 * writing a reply back to the client and then waiting for a response...
 * You can't listen for something after you wrote back (failed to write back
 * anyway due to some problems)
 * You can remove this code below, as it is redundant.
 */
/*
class ServerConnetionHandler implements Runnable
{
Socket clientSocket = null;

public ServerConnetionHandler (Socket inSoc){
clientSocket = inSoc;
}

public void run(){
try{
    //Catch the incoming data in a data stream, read a line and output it to the console
    DataInputStream dataIn = new DataInputStream(clientSocket.getInputStream());

    System.out.println("Client Connected");
    //Print out message
    System.out.println("--> " + dataIn.readUTF());

    //close the stream once we are done with it
    dataIn.close();
}
catch (Exception except){
    //Exception thrown (except) when something went wrong, pushing message to the console
    System.out.println("Error in ServerHandler--> " + 
            except.getMessage());
}
   }*/