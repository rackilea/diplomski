package com.sockets.exam1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerCode {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(11111);
            while (true) {                                              
                new ThreadSocket(server.accept());
            }
        } catch (Exception e) {
        }
    }
}
class ThreadSocket extends Thread{
    private Socket insocket;    
    ThreadSocket(Socket insocket){
        this.insocket = insocket;
        this.start();
    }       
    @Override
    public void run() {     
        try {
            System.out.println("procesing request");
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    insocket.getInputStream()));
            PrintWriter out = new PrintWriter(insocket.getOutputStream(),
                    true);
            String instring = in.readLine();
            out.println("The server got this: " + instring.toUpperCase());
            insocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }       
    }
}