import java.awt.BorderLayout;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import javax.swing.*;


public class KnockKnockClient extends JFrame
{

    public String fromServer;
    public String fromUser;
    // Added by me.--------------------
    private JTextArea tarea;
    private JTextField tfield;
    private JScrollPane spane;
    private PrintWriter out = null;
    /*------------------------------------*/

    public void Client() throws IOException 
    {
        Socket kkSocket = null;
        //PrintWriter out = null;  Shifted this to the instance variable
        BufferedReader in = null;

        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        try {
            kkSocket = new Socket("127.0.0.1", 4444);
            out = new PrintWriter(kkSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(kkSocket.getInputStream()));
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host: 127.0.0.1");
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to: 127.0.0.1");
            System.exit(1);
        }

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel contentPane = new JPanel();

        tarea = new JTextArea(10, 10);
        spane = new JScrollPane(tarea);
        tarea.setLineWrap(true);
        tfield = new JTextField(10);

        tfield.requestFocusInWindow();

        contentPane.setLayout(new BorderLayout());
        contentPane.add(spane, BorderLayout.CENTER);
        contentPane.add(tfield, BorderLayout.PAGE_END);

        setContentPane(contentPane);
        pack();
        setVisible(true); 

        Thread receiveMessage = new Thread(new ReceiveChat(in, stdIn, out));    
        receiveMessage.start();



        tfield.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                // Here you will send it to the server side too, put that code here
                fromUser = tfield.getText() + "\n";
                if (fromUser != null) 
                {
                    System.out.println("Client: " + fromUser);
                    tarea.append(fromUser);
                    out.println(fromUser);
                    tfield.setText("");
                }
            }
        });
        //out.close();
        //in.close();
        //stdIn.close();
        //kkSocket.close();
     }    

     private class ReceiveChat implements Runnable
     {
        private BufferedReader in;
        private BufferedReader stdIn;
        private PrintWriter out;

        public ReceiveChat(BufferedReader in, BufferedReader stdIn, PrintWriter out)
        {
            this.in = in;
            this.stdIn = stdIn;
            this.out = out;
        }

        public void run()
        {
            try
            {
                while ((fromServer = in.readLine()) != null) {
                //System.out.println("Server: " + fromServer);
                String str = "Server : " + fromServer + "\n";
                tarea.append(str);
                tarea.setCaretPosition(tarea.getDocument().getLength());

                if (fromServer.equals("Bye."))
                    break;
                /*Commented out by me.*/
                /*fromUser = stdIn.readLine();
                if (fromUser != null) {
                    System.out.println("Client: " + fromUser);
                    out.println(fromUser);
                }   */
                }
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
     }

    public static void main(String... args)
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                KnockKnockClient client = new KnockKnockClient();
                try
                {
                    client.Client();
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }
            }
        });
    }
}