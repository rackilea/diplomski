import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class Client extends JFrame{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private static String[] names = new String[]{ "Sara", "Jessica", "Tom", "Emanuel", "Joshua",
            "Kristin", "Kirito", "Goku", "Bulma" };
    private JTextField chatWindow;
    private static int c = 0;

    public void clientJoin(String name) {


            try {
                chatWindow = new JTextField();
                add(new JScrollPane(chatWindow));
                setSize(300, 150);
                setVisible(true);
                Socket socket = new Socket("localhost", 4444);
                PrintWriter printWriter = new PrintWriter(
                        socket.getOutputStream(), true);
                BufferedReader bufferedReader = new BufferedReader(
                        new InputStreamReader(System.in));
                System.out.println(name);

                System.out.println(name);
                while (true) {
                    String readerInput = bufferedReader.readLine();
                    printWriter.println(name + ": " + readerInput);
                    chatWindow.setText(name);
                }
            } catch (UnknownHostException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();

            }

    }

    public static void main(String[] args) {
        while (c < names.length-1) {
            Runnable r = new Runnable() {
                @Override
                public void run() {
                    new Client().clientJoin(names[c]);
                }
            };
            new Thread(r).start();
            System.out.println("ges here");
            c++;
        }

    }

}