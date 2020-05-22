/* User: koray@tugay.biz Date: 21/02/15 Time: 21:04 */

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class MySocketThread extends Thread {

    private volatile Socket socket;
    MyConnectionAccepter myConnectionAccepter;

    public MySocketThread(MyConnectionAccepter myConnectionAccepter) {
        this.myConnectionAccepter = myConnectionAccepter;
    }

    @Override
    public synchronized void run() {
        System.out.println("Started...");
        serve();
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
        System.out.println("Socket not null anymore..");
    }

    public void serve() {
        while(socket == null) {

        }
        while (socket != null) {
            Scanner scanner = null;
            try {
                scanner = new Scanner(socket.getInputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
            String readLine;
            while (!(readLine = scanner.nextLine()).equals("bye")) {
                System.out.println(readLine);
            }
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            socket = null;
            myConnectionAccepter.informIAmDone(this);
        }
        serve();
    }

}