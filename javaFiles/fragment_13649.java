package com.weebly.foxgenesis.src;
import java.net.*;
import java.io.*;

public final class ChatClient
{  
    private Socket socket = null;
    private DataOutputStream streamOut = null;
    private ChatClientThread client = null;
    private String serverName = "localhost";
    private int serverPort = -1;
    private final ChatReciever output;

/**
 * Create a new ChatClient that connects to a given server and receives UTF-8 encoded messages
 * @param a Client class
 */
public ChatClient(ChatReciever chatReciever)
{ 
    output = chatReciever;
    serverPort = chatReciever.getPort();
    serverName = chatReciever.getHost();
    connect(serverName, serverPort);
}

private void connect(String serverName, int serverPort)
{  
    output.handleLog("Establishing connection. Please wait ...");
    try
    {  
        socket = new Socket(serverName, serverPort);
        output.handle("Connected to chat server");
        open();
    }
    catch(UnknownHostException uhe)
    {  
        output.handleError("Host unknown: " + uhe.getMessage()); 
    }
    catch(IOException ioe)
    {  
        output.handleError("Unexpected exception: " + ioe.getMessage()); 
    } 
}

/**
 * Sends a message to the server through bytes in UTF-8 encoding 
 * @param msg message to send to the server
 */
public void send(String msg) throws IOException
{  
    streamOut.writeUTF(msg); 
    streamOut.flush();
}

/**
 * forces the ChatReciever to listen to a message (NOTE: this does not send anything to the server)
 * @param msg message to send
 */
public void handle(String msg)
{  
    output.handle(msg);
}

private void open() throws IOException
{   
    streamOut = new DataOutputStream(socket.getOutputStream());
    client = new ChatClientThread(this, socket); 
}

/**
 * tries to close 
 */
public void close() throws IOException
{  
    if (streamOut != null)  
        streamOut.close();
    if (socket    != null)  
        socket.close(); 
}

/**
 * closes the client connection
 */
@SuppressWarnings("deprecation")
public void stop()
{
    if(client != null)
        client.stop();
    client = null;
}

/**
 * checks if the ChatClient is currently connected to the server
 * @return Boolean is connected
 */
public boolean isConnected()
{
    return client == null ?(false) : (true);
}
}