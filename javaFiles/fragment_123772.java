import javax.swing.*;

import java.awt.event.*;
import java.awt.*;
import java.io.*;
import java.net.*;
import java.util.*;

class Chat implements KeyListener{
JTextArea incoming;
JTextField output, name;
JButton send;
BufferedReader reader;
PrintWriter writer;
Socket sock;

Set<String> badWords = new HashSet<>(Arrays.asList("hello"));


public static void main(String [] args){
    Chat c = new Chat();
    c.Start();
}
public void Start(){
    JFrame frame = new JFrame("Chat Client Alpha 1.1");
    frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
    frame.setSize(700,700);
    frame.setResizable(false);
    frame.setBackground(Color.black);

    JPanel center = new JPanel();
    JPanel south = new JPanel();
    JPanel north = new JPanel();

    JLabel EName = new JLabel("Enter your name: ");
    incoming = new JTextArea(35,45);
    send = new JButton("SEND");
    send.addActionListener(new SendMessageListener());
    output = new JTextField(40);
    name = new JTextField(37);

    name.setText("Default");

    incoming.setEditable(false);
    incoming.setLineWrap(true);

    JScrollPane sc = new JScrollPane(incoming);
    sc.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
    sc.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

    north.add(EName);
    north.add(name);
    center.add(sc);
    south.add(output);
    south.add(send);

    north.setBackground(Color.gray);
    center.setBackground(Color.gray);
    south.setBackground(Color.gray);

    setUpNetworking();

    Thread readerThread = new Thread(new IncomingReader());
    readerThread.start();

    frame.getContentPane().add(BorderLayout.NORTH, north);
    frame.getContentPane().add(BorderLayout.CENTER, center);
    frame.getContentPane().add(BorderLayout.SOUTH, south);

    frame.setVisible(true);
    } private void setUpNetworking(){
        try{
            sock = new Socket("89.99.7.141", 5000);
            InputStreamReader streamReader = new InputStreamReader(sock.getInputStream());
            reader = new BufferedReader(streamReader);
            writer = new PrintWriter(sock.getOutputStream());
            incoming.append("Networking Established" + "\n");
        }catch(IOException ex){
            ex.printStackTrace();
            incoming.append("Connecting Failed" + "\n");
        }
    }
    class SendMessageListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            try {
                if (badWords.contains(output.getText())) {
                    writer.println("(" + name.getText() + ")" + " " + "sorry bad words are not allowed");
                } else if (output.getText().length() > 0){
                    writer.println("(" + name.getText() + ")" + " " + output.getText());
                }
                writer.flush();
            }catch(Exception ex){
                ex.printStackTrace();
            }
            output.setText("");
            output.requestFocus();
        }
    }
    public class IncomingReader implements Runnable{
        public void run(){
            String message;
            try{
                while((message = reader.readLine()) !=null){
                    System.out.println("read" + message);
                    incoming.append(message + "\n");
                    }
                }catch(Exception ex){
                    ex.printStackTrace();

                }
            }
        }public void keyTyped(KeyEvent e){
            if (e.getKeyCode() == KeyEvent.VK_ENTER){
                new SendMessageListener();
                System.out.println("key typed");
            }
        }

        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER){
                new SendMessageListener();
                System.out.println("key pressed");
            }
        }

        public void keyReleased(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER){
                new SendMessageListener();
                System.out.println("key released");
            }

        }
    }