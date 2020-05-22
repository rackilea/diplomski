import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class GlobalQdaClient extends Thread {
        int serverPort = 7896;
        BufferedReader reader ;
        static String input = "";
        Socket s;
        DataInputStream in ;
        DataOutputStream out ;
public GlobalQdaClient() {
        try {
            reader  = new BufferedReader(new InputStreamReader(System.in));
             s = new Socket("localhost", serverPort);
             in = new DataInputStream(s.getInputStream());
             out = new DataOutputStream(s.getOutputStream());
        } catch (IOException ex) {
            Logger.getLogger(GlobalQdaClient.class.getName()).log(Level.SEVERE, null, ex);
        }
}

public static void main(String[] args) throws IOException {
    GlobalQdaClient client = new GlobalQdaClient();
    client.start();
    while(!client.input.equals("end")){
        client.input = client.reader.readLine();
        try{
            client.out.writeUTF(client.input);
            if(client.in.available()>0){
            String data = client.in.readUTF();
            System.out.println("Recieved this: " + data);            
            }
        }
        catch(UnknownHostException ex){
            System.out.println(ex.getMessage());
        }
        catch(EOFException ex){
            System.out.println(ex.getMessage());
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}    

@Override
public void run(){

    try {
        while(true){
            String data = in.readUTF();
            System.out.println("Recieved this: " + data);            
            }    
    } catch (IOException ex) {
            Logger.getLogger(Message.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}