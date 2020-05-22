import java.io.BufferedReader;
import java.io.*;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;



public class TcpServer {


public static void main(String[] args) {
    // The name of the file to open.
    String fileName = "input.txt";
    // This will reference one line at a time
    String line = null;
    String holder=null;
    String clientWord;
    int bytNumber;

    try
    {
        //create welcoming socket at port 5555
        ServerSocket welcomeSocket = new ServerSocket(5555);
        //wait, on welcoming socket for contact by client
        Socket connectionSocket = welcomeSocket.accept();
        //create input stream, attached to socket
        DataInputStream inFromClient =
                new DataInputStream(connectionSocket.getInputStream());
        //create output stream, attached to socket
        DataOutputStream outToClient =
                new DataOutputStream(connectionSocket.getOutputStream());
        //read in line from socket
        clientWord = inFromClient.readUTF();
    System.out.println(clientWord);

        if(clientWord.equals("query"))
        {


            try 
            {
         // FileReader reads text files in the default encoding.
         FileReader fileReader = new FileReader(fileName);


         // Always wrap FileReader in BufferedReader.
         BufferedReader buffer = new BufferedReader(fileReader);


                while((line = buffer.readLine()) != null) 
                {
             System.out.println(line);
             bytNumber = line.getBytes().length;
             holder=Integer.toString(bytNumber);
             //pr.println(bytNumber);//only printing first line not going until eof
            outToClient.writeBytes(holder);
             // line = buffer.readLine();
            // pr.flush();
                }   

         // Always close files.
         buffer.close();         
            }
            catch(FileNotFoundException ex) 
            {
         System.out.println(
             "Unable to open file '" + 
             fileName + "'");                
            }
            catch(IOException ex) 
            {
         System.out.println(
             "Error reading file '" 
             + fileName + "'");                  
         // Or we could just do this: 
         // ex.printStackTrace();
            }

        }// end if statement
    }

  catch(Exception ex)
    {

    }
}

}