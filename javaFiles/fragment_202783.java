/* User: koray@tugay.biz Date: 21/02/15 Time: 21:12 */

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Stack;

public class MyConnectionAccepter {

    private Stack<MySocketThread> mySocketThreads = new Stack<MySocketThread>();
    private volatile int currentNumberOfConnections = 0;

    public MyConnectionAccepter() {

        MySocketThread mySocketThreadOne = new MySocketThread(this);
        MySocketThread mySocketThreadTwo = new MySocketThread(this);

        mySocketThreadOne.setDaemon(true);
        mySocketThreadTwo.setDaemon(true);

        mySocketThreadOne.start();
        mySocketThreadTwo.start();

        mySocketThreads.push(mySocketThreadOne);
        mySocketThreads.push(mySocketThreadTwo);

    }

    public void start() throws IOException {

        ServerSocket serverSocket = new ServerSocket(8888);

        while (true) {
            while (currentNumberOfConnections < 2) {
                System.out.println("Blocking now:");
                Socket accept = serverSocket.accept();
                System.out.println("Connection accepted..");
                MySocketThread mySocketThread = mySocketThreads.pop();
                mySocketThread.setSocket(accept);
                System.out.println("Incrementing connections..");
                currentNumberOfConnections++;
                System.out.println("End of while..");
            }
        }

    }

    public void informIAmDone(MySocketThread mySocketThread) {
        mySocketThreads.push(mySocketThread);
        currentNumberOfConnections--;
    }
}