package com.example.stackoverflow;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;

public class MainActivity extends Activity {
   private static final String LOG_TAG = "TEMP";
   InputStream inputStr;
   String inputJSON = null;
   Socket socket = new Socket();
   String outputJSONserv = "asdasd";

@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    Log.e(LOG_TAG, "Start Repeat Timer");
    TimerTask task = new RepeatingTask();
    Timer timer = new Timer();
    timer.scheduleAtFixedRate(task, 0, 3000);
    Log.e(LOG_TAG, "Started Repeat Timer");
}

@Override
public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.activity_main, menu);
    return true;
}

public class RepeatingTask extends TimerTask {
    // private int len = 0;
    // private byte[] input = new byte[len];

    public RepeatingTask() {
        Log.e(LOG_TAG, "In RepeatingTask()");
        Log.e(LOG_TAG, "Before inputJSON String");

        try {
            inputJSON = ConvertByteArrayToString(readBytes(inputStr));
            sendBytes(ConvertStringToByteArray(inputJSON), 0,
                    ConvertStringToByteArray(inputJSON).length);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // Convert
        Log.e(LOG_TAG, "After inputJSON String:" + inputJSON);

        // LOOK HERE FIRST
        // inputJSON is what is received back from the server - Take the
        // inputJSON
        // String and use regular expressions HERE to remove all the other
        // characters in the
        // string except the payload JSON.
        // refreshViewModels(inputJSON);
    }

    @Override
    public void run() {
        /*
         * try { Log.e(LOG_TAG, "IN REPEATINGTHREAD-INPUTJSON");
         * //outputstrwr.write(outputJSONserv); //UNCOMMENT IF NEED TO SEND
         * DATA TO GET JSON BACK //inputJSON =
         * ConvertByteArrayToString(getBytesFromInputStream(inputStr));
         * inputJSON = ConvertByteArrayToString(getFileBytes(inputStr)); }
         * catch (IOException e) { // TODO Auto-generated catch block
         * e.printStackTrace(); }
         * 
         * Log.e(LOG_TAG, "IN REPEATINGTHREAD-INPUTJSON2:" + inputJSON);
         * refreshViewModels(inputJSON);
         */

        try {
            Log.e(LOG_TAG, "IN REPEATINGTHREAD-INPUTJSON");
            // outputstrwr.write(outputJSONserv); //UNCOMMENT IF NEED TO
            // SEND DATA TO GET JSON BACK
            // byte[] = myByteArray = readBytes(inputStr);
            sendBytes(ConvertStringToByteArray(outputJSONserv), 0,
                    ConvertStringToByteArray(outputJSONserv).length);
            // sendBytes(myByteArray, 0, myByteArray.length);
            Log.e(LOG_TAG, "AFTER SENDING DATA");
            // inputJSON =
            // ConvertByteArrayToString(getBytesFromInputStream(inputStr));
            inputJSON = ConvertByteArrayToString(readBytes(inputStr));
            Log.e(LOG_TAG, "IN REPEATINGTHREAD-INPUTJSON2:" + inputJSON);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        Log.e(LOG_TAG, "IN REPEATINGTHREAD-INPUTJSON3:" + inputJSON);
        //refreshViewModels(inputJSON);
    }
}

public void sendBytes(byte[] myByteArray, int start, int len)
                                                             throws IOException {
    if (len < 0)
        throw new IllegalArgumentException("Negative length not allowed");
    if (start < 0 || start >= myByteArray.length)
        throw new IndexOutOfBoundsException("Out of bounds: " + start);
    // Other checks if needed.

    // May be better to save the streams in the support class;
    // just like the socket variable.

    OutputStream out = socket.getOutputStream();
    DataOutputStream dos = new DataOutputStream(out);

    dos.writeInt(len);
    if (len > 0) {
        dos.write(myByteArray, start, len);
    }
}

public byte[] readBytes(InputStream in) throws IOException {
    // Again, probably better to store these objects references in the
    // support class
    in = socket.getInputStream();
    DataInputStream dis = new DataInputStream(in);

    int len = dis.readInt();
    byte[] data = new byte[len];
    if (len > 0) {
        dis.readFully(data);
    }
    return data;
}

public String ConvertByteArrayToString(byte[] b) {
    // byte[] to string
    String input = new String(b);
    return input;
}

public byte[] ConvertStringToByteArray(String str) {
    // string to byte[]
    byte[] bytes = str.getBytes();
    return bytes;
}