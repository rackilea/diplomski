package serversideserver;

import java.io.*;
import java.net.*;

/**
 * Title:        Sample Server
 * Description:  This utility will accept input from a socket, posting back to the socket before closing the link.
 * It is intended as a template for coders to base servers on. Please report bugs to brad at kieser.net
 * Copyright:    Copyright (c) 2002
 * Company:      Kieser.net
 * @author B. Kieser
 * @version 1.0
 */

public class Serversideserver {

    private static int port             =4445;
    private static int maxConnections   =10;

    private static int connections = 0;

    synchronized static void connectionClosed() {
        connections--;
        Serversideserver.class.notify();
    }

    /**
     * The blocking mechanism to only allow <code>maxConnections<code> 
     * @throws InterruptedException
     *      thrown if blocking thread is interupted
     */
    private synchronized static void nextConnection() throws InterruptedException {
        while(connections>=maxConnections) {
            Serversideserver.class.wait();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        try{
            // server socket
            ServerSocket listener = new ServerSocket(port);
            // socket
            Socket socket;

            // Keep the server alive
            while(true){
                // Blocks if we have reached the max
                nextConnection();

                // Accept connection to client
                socket = listener.accept();

                // define request service
                doComms conn_c= new doComms(socket,socket.getInetAddress().getCanonicalHostName());
                Thread t = new Thread(conn_c);
                t.setDaemon(false);

                // run request service
                t.start();
            }
        } catch (IOException ioe) {
            System.out.println("IOException on socket listen: " + ioe);
            ioe.printStackTrace();
        }
    }
}