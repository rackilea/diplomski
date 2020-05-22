/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package serversideserver;
import java.io.*;
import java.net.*;


class doComms implements Runnable {
    private Socket socket;
    private String ip;

    doComms(Socket socket, String ip) {
        this.socket = socket;
        this.ip = ip;
    }

    public void run () {
        try {
            // Define input/output
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintStream out = new PrintStream(socket.getOutputStream());

            // Process requests until the EOF is found
            String line;
            while((line = in.readLine()) != null && !line.equals(".")) {
                // print input
                System.out.println("LINE: " + line);

                // print process line
                System.out.println("UPDATE `solvers` SET `online`='1',`ip`='"+  ip +"' WHERE `user`='"+ line +"'");

                // write response
                out.println("{\"captcha\":1,\"text\":\"abc\",\"is_correct\":\"true\"}");
            }

            socket.close();
        } catch (IOException ioe) {
            System.out.println("IOException on socket listen: " + ioe);
            ioe.printStackTrace();
        } finally {
        Serversideserver.connectionClosed();
    }
    }
}