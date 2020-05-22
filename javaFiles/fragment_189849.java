package client;

import java.net.InetSocketAddress;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.util.logging.Level;
import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.future.ConnectFuture;
import org.apache.mina.core.future.IoFutureListener;
import org.apache.mina.core.future.ReadFuture;
import org.apache.mina.core.service.IoConnector;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.example.udp.client.MemMonClient;
import org.apache.mina.transport.socket.nio.NioDatagramConnector;

/**
 *
 * @author az
 */
public class CustomClient extends IoHandlerAdapter{

    private IoSession session;
    private IoConnector connector;
    private ConnectFuture connFuture;

    public CustomClient() throws InterruptedException{
        connector = new NioDatagramConnector();
        connector.setHandler(this);
        connFuture = connector.connect(new InetSocketAddress("192.168.3.22",6502));


        connFuture.addListener(new IoFutureListener<ConnectFuture>() {
            public void operationComplete(ConnectFuture future) {
                if (future.isConnected()) {                    
                    session = future.getSession();
                    try {
                        try {
                            sendData();
                          //  connFuture.await();

                        } catch (CharacterCodingException ex) {
                            java.util.logging.Logger.getLogger(MemMonClient.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } 
            }
        });

    }
    private void sendData() throws InterruptedException, CharacterCodingException {


            IoBuffer buffer = IoBuffer.allocate(8);
            buffer.setAutoExpand(true);
            buffer.putString("any", Charset.forName("UTF-8").newEncoder());
            buffer.flip();
            session.write(buffer);
    }

     @Override
    public void exceptionCaught(IoSession session, Throwable cause)
            throws Exception {
        cause.printStackTrace();
    }
    @Override
    public void messageReceived(IoSession session, Object message)
            throws Exception {
        connFuture.getSession().getConfig().setUseReadOperation(true);

        ReadFuture r = connFuture.getSession().read();
        connFuture.await();
        connFuture.getSession().getConfig().setUseReadOperation(true);


        Object obj = r.getMessage();
        System.out.println("r.getMessage(); "+obj);
        IoBuffer buffer = IoBuffer.allocate(2048);
                        buffer.setAutoExpand(true);                     
                        Object objReceived = buffer.getObject();
                        System.out.println(objReceived.toString());

        System.out.println("reveived Session recv...");
    }

    @Override
    public void messageSent(IoSession session, Object message) throws Exception {
        System.out.println("Message sent...");
    }

    @Override
    public void sessionClosed(IoSession session) throws Exception {
        System.out.println("Session closed...");
    }

    @Override
    public void sessionCreated(IoSession session) throws Exception {
        System.out.println("Session created...");
    }

    @Override
    public void sessionIdle(IoSession session, IdleStatus status)
            throws Exception {
        System.out.println("Session idle...");
    }

    @Override
    public void sessionOpened(IoSession session) throws Exception {
        System.out.println("Session opened...");
    }
    public static void main (String are[]){
        try{
        new CustomClient();
        }catch(Exception ex){ex.printStackTrace();}
    }
}

POJO Java
package pojo;

import java.io.Serializable;

/**
 *
 * @author az
 */
public class kojo implements Serializable{
    private String name = "null";
    private String address = "null";

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

}

Custom Server Java
package server;

import java.io.IOException;
import java.net.InetSocketAddress;
import org.apache.mina.transport.socket.DatagramSessionConfig;
import org.apache.mina.transport.socket.nio.NioDatagramAcceptor;

/**
 *
 * @author az
 */
public class CustomServer {

    public CustomServer(){
        try {
            NioDatagramAcceptor acceptor = new NioDatagramAcceptor();
            acceptor.setHandler(new ServerHandler(this));
            //DefaultIoFilterChainBuilder filter = acceptor.getFilterChain();
            DatagramSessionConfig dcfg = acceptor.getSessionConfig();
            dcfg.setReuseAddress(true);
            acceptor.bind(new InetSocketAddress(6501));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void receiveUpdate(){

    }
    public static void main(String are[]){
        new CustomServer();
    }
}

Server Handler
package server;

import java.nio.charset.Charset;
import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.future.WriteFuture;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;

/**
 *
 * @author az
 */
public class ServerHandler extends IoHandlerAdapter {

    private CustomServer server;

    public ServerHandler(CustomServer server) {
        this.server = server;
    }

    @Override
    public void messageReceived(IoSession session, Object message)
            throws Exception {

        if (message instanceof IoBuffer) {
            //decode POJO and send to client
            IoBuffer buffer = (IoBuffer) message;
            System.out.println(buffer.getString(Charset.forName("UTF-8").newDecoder()));
            buffer.setAutoExpand(true);
            buffer.putObject(new pojo.POJO());
            buffer.flip();
            session.write(buffer);

            System.out.print("Object Attached and Sent");

        }
    }

    @Override
    public void messageSent(IoSession session, Object message) {
        System.out.println("Message sent");
    }

    @Override
    public void sessionClosed(IoSession session) throws Exception {
        System.out.println("Session closed...");
    }

    @Override
    public void sessionCreated(IoSession session) throws Exception {
        System.out.println("Session created...");
    }

    @Override
    public void sessionIdle(IoSession session, IdleStatus status)
            throws Exception {
        System.out.println("Session idle...");
    }

    @Override
    public void sessionOpened(IoSession session) throws Exception {
        System.out.println("Session Opened...");
    }
}