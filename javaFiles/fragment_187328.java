#Server Activity
package inc.teckzy.wifi_chat;

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
import java.net.ServerSocket;
import java.net.Socket;

public class Helper extends AppCompatActivity {
    EditText smessage;
    TextView chat,display_status;
    String str,Smsg,Cmsg="";
    int serverport = 6666;
    ServerSocket serverSocket;
    Socket client;
    Handler updateConversationHandler =new Handler();
    WifiManager wmanager;
    DataOutputStream out;
    DataInputStream in;
    Button button_sent;
    StringWriter errors = new StringWriter();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_helper);

        wmanager = (WifiManager) getSystemService(WIFI_SERVICE);
        @SuppressWarnings("deprecation")
        String ip = Formatter.formatIpAddress(wmanager.getConnectionInfo().getIpAddress());
        smessage = (EditText) findViewById(R.id.smessage);
        chat = (TextView) findViewById(R.id.chat);
        display_status = (TextView) findViewById(R.id.display_status);



        Thread serverThread = new Thread(new serverThread());
        serverThread.start();

        display_status.setText("Hosted on: " + ip);
        button_sent = (Button) findViewById(R.id.button_sent);


        button_sent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                        out = new DataOutputStream(client.getOutputStream());
                        str = smessage.getText().toString();
                        Smsg = "Server:" + str;
                        updateConversationHandler.post(new updateUIThread(Smsg));
                        out.writeUTF(str);
                        out.flush();
                }catch (Exception e) {
                    e.printStackTrace(new PrintWriter(errors));
                    updateConversationHandler.post(new updateUIThread(errors.toString()));
                }
                smessage.getText().clear();
            }
        });
}

    public class serverThread implements Runnable {
        @Override
        public void run() {
            try {
                serverSocket = new ServerSocket(serverport);
                while (true) {
                    client = serverSocket.accept();
                    updateConversationHandler.post(new updateUIThread("Connected"));
/*******************************************
 setup i/p streams
 ******************************************/
                    in = new DataInputStream(client.getInputStream());
                    String line = "";
                    while (!line.equals("STOP")) {
                        line=in.readUTF();
                        Cmsg ="Client: "+ line;
                        updateConversationHandler.post(new updateUIThread(Cmsg));
                    }
                    in.close();
                    client.close();
                }
            } catch (Exception e) {
                e.printStackTrace(new PrintWriter(errors));
                updateConversationHandler.post(new updateUIThread(errors.toString()));
            }

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
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}