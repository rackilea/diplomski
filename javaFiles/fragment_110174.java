package tfe.rma.ciss.be;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlrpc.android.MethodCall;
import org.xmlrpc.android.XMLRPCServer;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import java.io.IOException;
import java.io.StringReader;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class Server extends IntentService {
    public String myData="";
    public String streamTitle = "",path="";

    public void onCreate() {
        super.onCreate();
        Log.d("Server", ">>>onCreate()");
    }

    public Server() {
        super("Server");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        super.onStartCommand(intent, startId, startId);
        Log.i("LocalService", "Received start id " + startId + ": " + intent);

        return START_STICKY;
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Log.d("Server", ">>>handlingIntent()");
        try {
            ServerSocket socket = new ServerSocket(8214);
            XMLRPCServer server = new XMLRPCServer();
            Log.d("Server", ">>>opening on port" + socket);

            while (true) {
                Socket client = socket.accept();
                MethodCall call = server.readMethodCall(client);
                String name = call.getMethodName();

                if (name.equals("newImage")) {
                    ArrayList<Object> params = call.getParams();
                    // assume "add" method has two Integer params, so no checks done
                    myData = (String)( params.get(0));
                    //int i1 = (Integer) params.get(1);
                    server.respond(client, new Object[] {200});
                    /*intent = new Intent (this, ParseFunction.class);
                    startService (intent);  */

                    Toast.makeText(this, myData, Toast.LENGTH_SHORT).show();  
                    Log.d("ParseFunction", ">>>Started()"); 

                    Intent i = new Intent( this, B.class );
                    i.putExtra( "Azo", myData);
                    i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity( i );
                } else {
                    server.respond(client, null);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        }
    }
}