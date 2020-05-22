import java.awt.event.*;
import javax.swing.*;
import java.net.*;
import java.io.*;
import java.util.logging.*;

public class Example extends JApplet {
    private ServerSocket ss ;
    private Socket socket;
    private boolean closed;

    @Override
    public void init(){
        JButton stop = new JButton("Stop!");
        stop.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                closed();
            }
        });
        add( stop );
        validate();

        Runnable r = new Runnable() {
            public void run() {
                try {
                    initialize();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        };
        Thread t = new Thread(r);
        t.start();
    }

    public void closed() {
        System.out.println("Inside close");
        closed=true;
        try {
            ss.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void initialize() throws IOException {
        ss =new ServerSocket(5002);
        while(!closed){
            System.out.println("Waiting to accept request");
            socket = ss.accept();
            System.out.println("Request accepted");
        }
    }
}