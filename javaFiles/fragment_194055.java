import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;
import org.apache.commons.lang3.RandomStringUtils;

import java.io.IOException;
import java.net.*;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class HttpEventMain
{
    private InetAddress addr;
    private int port;
    private Selector selector;
    private HttpEventProducer producer ;
    private ConcurrentHashMap concurrentHashMapResponse;
    private ConcurrentHashMap concurrentHashMapKey;

    public HttpEventMain(InetAddress addr, int port) throws IOException {
        this.setAddr(addr);
        this.setPort(port);
        this.setConcurrentHashMapResponse(new ConcurrentHashMap<>());
        this.concurrentHashMapKey = new ConcurrentHashMap<>();
    }


    public static void main(String[] args) throws Exception
    {
        System.out.println("----- Running the server on machine with "+Runtime.getRuntime().availableProcessors()+" cores -----");

        HttpEventMain server = new HttpEventMain(null, 4333);



        HttpEventFactory factory = new HttpEventFactory();


        int bufferSize = 1024;


        Executor executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors()); // a thread pool to which we can assign tasks


        Disruptor<HttpEvent> disruptor = new Disruptor<HttpEvent>(factory, bufferSize, executor);

        HttpEventHandler [] handlers = new HttpEventHandler[Runtime.getRuntime().availableProcessors()];

        for(int i = 0; i<Runtime.getRuntime().availableProcessors();i++){
            handlers[i] = new HttpEventHandler(i, server.getConcurrentHashMapResponse());
        }


        disruptor.handleEventsWith(handlers);




        disruptor.start();


        RingBuffer<HttpEvent> ringBuffer = disruptor.getRingBuffer();

        server.setProducer(new HttpEventProducer(ringBuffer, server.getConcurrentHashMapResponse()));

        try {
            System.out.println("\n====================Server Details====================");
            System.out.println("Server Machine: "+ InetAddress.getLocalHost().getCanonicalHostName());
            System.out.println("Port number: " + server.getPort());

        } catch (UnknownHostException e1) {
            e1.printStackTrace();
        }

        try {

            server.start();

        } catch (IOException e) {
            System.err.println("Error occured in HttpEventMain:" + e.getMessage());
            System.exit(0);
        }



    }
    private void start() throws IOException {
        this.selector = Selector.open();
        ServerSocketChannel serverChannel = ServerSocketChannel.open();
        serverChannel.configureBlocking(false);


        InetSocketAddress listenAddr = new InetSocketAddress(this.addr, this.port);
        serverChannel.socket().bind(listenAddr);
        serverChannel.register(this.selector, SelectionKey.OP_ACCEPT);

        System.out.println("Server ready. Ctrl-C to stop.");

        while (true) {

            this.selector.select();


            Iterator keys = this.selector.selectedKeys().iterator();
            while (keys.hasNext()) {
                SelectionKey key = (SelectionKey) keys.next();

                keys.remove();

                if (! key.isValid()) {
                    continue;
                }

                if (key.isAcceptable()) {
                    this.accept(key);
                }
                else if (key.isReadable()) {
                    this.read(key);
                }
                else if (key.isWritable()) {
                    this.write(key);
                }
            }
        }

    }

    private void accept(SelectionKey key) throws IOException {

        ServerSocketChannel serverChannel = (ServerSocketChannel) key.channel();
        SocketChannel channel = serverChannel.accept();
        channel.configureBlocking(false);


        Socket socket = channel.socket();
        SocketAddress remoteAddr = socket.getRemoteSocketAddress();

        channel.register(this.selector, SelectionKey.OP_READ);
    }

    private void read(SelectionKey key) throws IOException {

        SocketChannel channel = (SocketChannel) key.channel();

        ByteBuffer buffer = ByteBuffer.allocate(8192);
        int numRead = -1;
        try {
            numRead = channel.read(buffer);
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        if (numRead == -1) {

            Socket socket = channel.socket();
            SocketAddress remoteAddr = socket.getRemoteSocketAddress();
            channel.close();
            key.cancel();
            return;

        }
        String requestID = RandomStringUtils.random(15, true, true);

        while(concurrentHashMapKey.containsValue(requestID) || concurrentHashMapResponse.containsKey(requestID)){
            requestID = RandomStringUtils.random(15, true, true);
        }

        concurrentHashMapKey.put(key, requestID);

        this.producer.onData(requestID, buffer, numRead);

        channel.register(this.selector, SelectionKey.OP_WRITE, buffer);
    }

    private boolean responseReady(SelectionKey key){

        String requestId = concurrentHashMapKey.get(key).toString();
        String response = concurrentHashMapResponse.get(requestId).toString();

        if(response!="0"){
            concurrentHashMapKey.remove(key);
            concurrentHashMapResponse.remove(requestId);
            return true;
        }else{
            return false;
        }

    }

    private void write(SelectionKey key) throws IOException {

        if(responseReady(key)) {
            SocketChannel channel = (SocketChannel) key.channel();
            ByteBuffer inputBuffer = (ByteBuffer) key.attachment();
            inputBuffer.flip();
            channel.write(inputBuffer);
            channel.close();
            key.cancel();

        }

    }

    public HttpEventProducer getProducer() {
        return producer;
    }

    public void setProducer(HttpEventProducer producer) {
        this.producer = producer;
    }

    public ConcurrentHashMap getConcurrentHashMapResponse() {
        return concurrentHashMapResponse;
    }

    public void setConcurrentHashMapResponse(ConcurrentHashMap concurrentHashMapResponse) {
        this.concurrentHashMapResponse = concurrentHashMapResponse;
    }

    public InetAddress getAddr() {
        return addr;
    }

    public void setAddr(InetAddress addr) {
        this.addr = addr;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public Selector getSelector() {
        return selector;
    }

    public void setSelector(Selector selector) {
        this.selector = selector;
    }
}