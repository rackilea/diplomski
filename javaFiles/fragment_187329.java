#Client Activity
package inc.teckzy.wifi_chat.reciever;

import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.text.format.Formatter;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.InetAddress;
import java.net.Socket;

import inc.teckzy.wifi_chat.R;

public class ClientSide extends AppCompatActivity {
    EditText serverIp,smessage;
    TextView chat;
    String serverIpAddress = "",Smsg,Cmsg = "",str;
    Handler updateConversationHandler = new Handler();
    Button sent,connectPhones;
    Socket socket;
    DataInputStream in;
    DataOutputStream out;
    StringWriter errors = new StringWriter();
    WifiManager wmanager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_side);
        chat = (TextView) findViewById(R.id.chat);
        serverIp = (EditText) findViewById(R.id.server_ip);
        wmanager = (WifiManager) getSystemService(WIFI_SERVICE);
        smessage = (EditText) findViewById(R.id.smessage);
        sent = (Button) findViewById(R.id.sent_button);
        connectPhones = (Button) findViewById(R.id.connect_phones);

        //-----------------------Connecting to IP------------------------------//
        connectPhones.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                serverIpAddress = serverIp.getText().toString();
                if (!serverIpAddress.equals(""))
                {
                    Thread clientThread = new Thread(new
                            ClientThread());
                    clientThread.start();
                }
            }
        });
        //-------------------------------Initializing sent thread----------------//
        sent.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                try {
                    out = new DataOutputStream(socket.getOutputStream());
                    str = smessage.getText().toString();
                    Cmsg = "Client: " + str;
                    updateConversationHandler.post(new updateUIThread(Cmsg));
                    out.writeUTF(str);
                    out.flush();
                }catch(Exception e){
                    e.printStackTrace(new PrintWriter(errors));
                    updateConversationHandler.post(new updateUIThread(errors.toString()));}
                smessage.getText().clear();
            }
        });

    }

    public class ClientThread implements Runnable
    {
        InetAddress serverAddr;
        public void run()
        {
            try
            {
                serverAddr = InetAddress.getByName(serverIpAddress);
                socket = new Socket(serverAddr, 6666);

                updateConversationHandler.post(new updateUIThread("Connected"));
                String ip = socket.getRemoteSocketAddress().toString();
                updateConversationHandler.post(new updateUIThread(ip));
                out = new DataOutputStream(socket.getOutputStream());
                in = new DataInputStream(socket.getInputStream());
/*******************************************
 setup i/p streams
 ******************************************/
                    String line = "";
                    while (!line.equals("Stop")) {
                        line=in.readUTF();
                        Smsg ="Server: " + line + "\n";
                        updateConversationHandler.post(new updateUIThread(Smsg));
                    }
                    out.close();
                    in.close();
                    socket.close();

            }
            catch (IOException e)
            {updateConversationHandler.post(new updateUIThread("IO Error"));}
        }
    }
    class updateUIThread implements Runnable {
        private String msg;
        updateUIThread(String str) {
            this.msg = str;
        }
        @Override
        public void run() {
            chat.setText(chat.getText().toString()+ msg + "\n");
        }
    }
    @Override
    protected void onStop() {
        super.onStop();
        try {
            // MAKE SURE YOU CLOSE THE SOCKET UPON EXITING
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}