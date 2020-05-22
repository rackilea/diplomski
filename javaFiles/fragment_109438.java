import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Main  
{
   public static void main(String[] args) throws IOException {

       Main m = new Main();
       m.connect();
   }

   public void connect() throws IOException{
     //declare a scanner so we can write a message
       Scanner keyboard = new Scanner(System.in);


       // localhost ip
       String ip = "127.0.0.1";
       int port = 4444;
       Socket socket = null;

       System.out.print("Enter your name: ");
       String name = keyboard.nextLine();

       try {

       //connect
       socket = new Socket(ip, port);

       //initialize streams
       DataInputStream in = new DataInputStream(socket.getInputStream());
       DataOutputStream out = new DataOutputStream(socket.getOutputStream());

       //start a thread which will start listening for messages
       new ReceiveMessage(in).start();

       // send the name to the server!
       out.writeUTF(name);

       while (true){
           //Write messages :)
           String message = keyboard.nextLine();
           out.writeUTF(message);
       }

       }
       catch (IOException e){
           e.printStackTrace();
            if (!socket.isClosed()){socket.close();}
       }
   }

   class ReceiveMessage extends Thread{

       DataInputStream in;

       ReceiveMessage(DataInputStream in){
           this.in = in;
       }

       public void run(){
           String message;
           while (true){
               try {
                    message = in.readUTF();
                    System.out.println(message);

                } catch (IOException e) {
                e.printStackTrace();
                }

           }
       }

   }

}