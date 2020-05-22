// derived from https://developer.android.com/google/gcm/ccs.html

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
//import javax.swing.JScrollPane;
//import javax.swing.SwingUtilities;

import org.jivesoftware.smack.ConnectionConfiguration;
import org.jivesoftware.smack.ConnectionConfiguration.SecurityMode;
import org.jivesoftware.smack.ConnectionListener;
import org.jivesoftware.smack.PacketInterceptor;
import org.jivesoftware.smack.PacketListener;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.SmackException.NotConnectedException;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.filter.PacketTypeFilter;
import org.jivesoftware.smack.packet.DefaultPacketExtension;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.packet.Packet;
import org.jivesoftware.smack.packet.PacketExtension;
import org.jivesoftware.smack.provider.PacketExtensionProvider;
import org.jivesoftware.smack.provider.ProviderManager;
import org.jivesoftware.smack.tcp.XMPPTCPConnection;
import org.jivesoftware.smack.util.StringUtils;
import org.json.simple.JSONValue;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.xmlpull.v1.XmlPullParser;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Random;
import java.net.*;
import java.io.*;
import java.util.*;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.HttpsURLConnection;

// list of all users and associated devices
class UserList {
    // (--deleted--)

    // constructor/read existing data from file
    public UserList() {
        // (--deleted--)
    }

    // add a new device to an existing user (called from networking thread)
    // duplicate IDs are quietly accepted
    public synchronized void addDevice( String uname, String newRegToken ) {
        // (--deleted--)
    }

    // generate a group address/notification key
    // !!!!!!!!!!!!!!! W A R N I N G !!!!!!!!!!!!!!!
    //   If the group addr/notification key is lost, it currently CANNOT be recovered/rebuilt
    public String createNotificationKey( String nKeyName, String addr ) {
        String[] idset = new String[1];
        idset[0] = addr;

        String newGroupAddr;

        try {
            // create a https connection to create the notification_key
            URL url = new URL( "https://android.googleapis.com/gcm/notification" );
            HttpsURLConnection conn = (HttpsURLConnection)url.openConnection();

            // send as a POST request
            conn.setRequestMethod("POST");

            // add request parameters
            conn.addRequestProperty( "project_id", ""+GcmPushServer.senderId );
            conn.addRequestProperty( "Authorization", "key="+GcmPushServer.password );
            // use "set" since this may already exist
            conn.setRequestProperty( "Content-Type", "application/json" );

            // create data to send with request
            Map<String,Object> sendData = new HashMap<>();

            // create a new notification key
            sendData.put( "operation", "create" );
            sendData.put( "notification_key_name", (--deleted--) );
            sendData.put( "registration_ids", (--deleted--) );

            String strData = JSONValue.toJSONString(sendData);

            // Send post request
            conn.setDoOutput(true);
            DataOutputStream wr = new DataOutputStream(conn.getOutputStream());
            wr.writeBytes( strData );
            wr.flush();
            wr.close();

            // successful?
            int rc = conn.getResponseCode();
            //System.out.println("ResponseCode = " + rc );

            // read the response
            Scanner input = new Scanner( conn.getInputStream() );
            String resp="";

            // read/display lines
            while( input.hasNextLine() ) {
                String s = input.nextLine();
                resp += s;
            }

            //System.out.println("Response content: " + resp);

            if ( rc == HttpsURLConnection.HTTP_OK ) {
                JSONObject obj = (JSONObject) JSONValue.parse(resp);

                newGroupAddr = (String) obj.get( "notification_key" );
                //System.out.println(" new notification_key: " + newGroupAddr );
                return newGroupAddr;
            } else {

            }
        } catch ( Exception e ) {
            //System.out.println("-- Exception: " + e.getMessage() );
        }

        return null;
    }

    // add/delete a single address to/from a notification key
    //  (add if doAdd is true, delete otherwise)
    // removing final address will quietly delete the key
    public static void modifyNotificationKey( String nKeyName, String nKey,
                    String addr, boolean doAdd ) {
        String[] idset = new String[1];
        idset[0] = addr;

        try {
            // create a https connection to create the notification_key
            URL url = new URL( "https://android.googleapis.com/gcm/notification" );
            HttpsURLConnection conn = (HttpsURLConnection)url.openConnection();

            // send as a POST request
            conn.setRequestMethod("POST");

            // add request parameters
            conn.addRequestProperty( "project_id", ""+GcmPushServer.senderId );
            conn.addRequestProperty( "Authorization", "key="+GcmPushServer.password );
            // use "set" since this may already exist
            conn.setRequestProperty( "Content-Type", "application/json" );

            // create data to send with request
            Map<String,Object> sendData = new HashMap<>();

            // create a new notification key
            sendData.put( "operation", doAdd? "add" : "remove" );       // add or delete key?
            sendData.put( "notification_key_name", (--deleted--) );
            sendData.put( "notification_key", (--deleted--) );
            sendData.put( "registration_ids", (--deleted--) );

            String strData = JSONValue.toJSONString(sendData);
            //System.out.println("genGroupAddress POST data: " + strData );

            // Send post request
            conn.setDoOutput(true);
            DataOutputStream wr = new DataOutputStream(conn.getOutputStream());
            wr.writeBytes( strData );
            wr.flush();
            wr.close();

            //conn.openConnection();

            // successful?
            int rc = conn.getResponseCode();
            //System.out.println("ResponseCode = " + rc );

            Scanner input = new Scanner( conn.getInputStream() );

            // read/display lines
            while( input.hasNextLine() ) {
                System.out.println("Response content:");
                String s = input.nextLine();
                System.out.println( s );
            }
        } catch ( Exception e ) {
            // do nothing
        }
    }
}

// text area for log messages
class LogTextArea extends JTextArea {
    // update the "log" with the specified message
    public void logMessage( String msg ) {
        // (--deleted--)
    }
}

class CcsServer {
    private static final String GCM_SERVER = "gcm.googleapis.com";
    private static final int GCM_PORT = 5235;

    private static final String GCM_ELEMENT_NAME = "gcm";
    private static final String GCM_NAMESPACE = "google:mobile:data";

    // display/log area
    LogTextArea logArea;
    UserList users;

    CcsServer( LogTextArea lta, UserList u ) {
        logArea = lta;
        users = u;
    }

    static {
        ProviderManager.addExtensionProvider(GCM_ELEMENT_NAME, GCM_NAMESPACE,
            new PacketExtensionProvider() {
                @Override
                public PacketExtension parseExtension(XmlPullParser parser) throws
                        Exception {
                    String json = parser.nextText();
                    return new GcmPacketExtension(json);
                }
            });
    }

    private XMPPConnection connection;

    /**
     * Indicates whether the connection is in draining state, which means that it
     * will not accept any new downstream messages.
     */
    protected volatile boolean connectionDraining = false;

    /**
     * Sends a downstream message to GCM.
     *
     * @return true if the message has been successfully sent.
     */
    public boolean sendDownstreamMessage(String jsonRequest) throws
            NotConnectedException {
        if (!connectionDraining) {
            send(jsonRequest);
            return true;
        }
        logArea.logMessage("Dropping downstream message since the connection is draining");
        return false;
    }

    /**
     * Returns a random message id to uniquely identify a message.
     *
     * <p>Note: This is generated by a pseudo random number generator for
     * illustration purpose, and is not guaranteed to be unique.
     */
    public String nextMessageId() {
        return "m-" + UUID.randomUUID().toString();
    }

    /**
     * Sends a packet with contents provided.
     */
    protected void send(String jsonRequest) throws NotConnectedException {
        Packet request = new GcmPacketExtension(jsonRequest).toPacket();
        connection.sendPacket(request);
    }

    /**
     * Handles an upstream data message from a device application.
     *
     * <p>This sample echo server sends an echo message back to the device.
     * Subclasses should override this method to properly process upstream messages.
     */
    protected void handleUpstreamMessage(Map<String, Object> jsonObject) {
        // PackageName of the application that sent this message.
        String category = (String) jsonObject.get("category");
        String from = (String) jsonObject.get("from");
        @SuppressWarnings("unchecked")
        Map<String, String> payload = (Map<String, String>) jsonObject.get("data");

        // what type of upstream message is this?
        if ( ! payload.containsKey( "my_action" ) )
        {
            // Hmmm - this shouldn't happen!
            logArea.logMessage( "handleUpstreamMessage - incoming message is missing my_action" );
            // just ignore the  message
            return;
        }

        // what action do they want?
        String my_action = (String) payload.get( "my_action" );
        if ( my_action.equals( "edu.eku.styere.gcmpushclient.REGISTER" ) ) {
            // registration request
            String username = (String) payload.get( "username" );

            logArea.logMessage( "Registration request: user=" + username + ", ID/Token=" + from );

            // save the information
            users.addDevice( username, from );

            return;
        } else {
            // take default action of echoing the message       
            payload.put("ECHO", "Application: " + category);

            // Send an ECHO response back
            String echo = createJsonMessage(from, nextMessageId(), payload,
                    "echo:CollapseKey", null, false);

            try {
                sendDownstreamMessage(echo);
            } catch (NotConnectedException e) {
                logArea.logMessage( "Not connected anymore, echo message is not sent: " + e.getMessage() );
            }
        }
    }

    /**
     * Handles an ACK.
     *
     * <p>Logs a INFO message, but subclasses could override it to
     * properly handle ACKs.
     */
    protected void handleAckReceipt(Map<String, Object> jsonObject) {
        String messageId = (String) jsonObject.get("message_id");
        String from = (String) jsonObject.get("from");
        logArea.logMessage( "handleAckReceipt() from: " + from + ", messageId: " + messageId );
    }

    /**
     * Handles a NACK.
     *
     * <p>Logs a INFO message, but subclasses could override it to
     * properly handle NACKs.
     */
    protected void handleNackReceipt(Map<String, Object> jsonObject) {
        String messageId = (String) jsonObject.get("message_id");
        String from = (String) jsonObject.get("from");
        logArea.logMessage( "handleNackReceipt() from: " + from + ", messageId: " + messageId );
    }

    protected void handleControlMessage(Map<String, Object> jsonObject) {
        logArea.logMessage( "handleControlMessage(): " + jsonObject );
        String controlType = (String) jsonObject.get("control_type");
        if ("CONNECTION_DRAINING".equals(controlType)) {
            connectionDraining = true;
        } else {
            logArea.logMessage( "Unrecognised control type: " + controlType + ". This could "+
                    "happen if new features are " + "added to the CCS protocol." );
        }
    }

    /**
     * Creates a JSON encoded GCM message.
     *
     * @param to RegistrationId of the target device (Required).
     * @param messageId Unique messageId for which CCS sends an
     *         "ack/nack" (Required).
     * @param payload Message content intended for the application. (Optional).
     * @param collapseKey GCM collapse_key parameter (Optional).
     * @param timeToLive GCM time_to_live parameter (Optional).
     * @param delayWhileIdle GCM delay_while_idle parameter (Optional).
     * @return JSON encoded GCM message.
     */
    public static String createJsonMessage(String to, String messageId,
            Map<String, String> payload, String collapseKey, Long timeToLive,
            Boolean delayWhileIdle) {
        Map<String, Object> message = new HashMap<String, Object>();
        message.put("to", to);
        if (collapseKey != null) {
            message.put("collapse_key", collapseKey);
        }
        if (timeToLive != null) {
            message.put("time_to_live", timeToLive);
        }
        if (delayWhileIdle != null && delayWhileIdle) {
            message.put("delay_while_idle", true);
        }
      message.put("message_id", messageId);
      message.put("data", payload);
      return JSONValue.toJSONString(message);
    }

    /**
     * Creates a JSON encoded ACK message for an upstream message received
     * from an application.
     *
     * @param to RegistrationId of the device who sent the upstream message.
     * @param messageId messageId of the upstream message to be acknowledged to CCS.
     * @return JSON encoded ack.
     */
        protected static String createJsonAck(String to, String messageId) {
        Map<String, Object> message = new HashMap<String, Object>();
        message.put("message_type", "ack");
        message.put("to", to);
        message.put("message_id", messageId);
        return JSONValue.toJSONString(message);
    }

    /**
     * Connects to GCM Cloud Connection Server using the supplied credentials.
     *
     * @param senderId Your GCM project number
     * @param apiKey API Key of your project
     */
    public void connect(long senderId, String apiKey)
            throws XMPPException, IOException, SmackException {
        ConnectionConfiguration config =
                new ConnectionConfiguration(GCM_SERVER, GCM_PORT);
        config.setSecurityMode(SecurityMode.enabled);
        config.setReconnectionAllowed(true);
        config.setRosterLoadedAtLogin(false);
        config.setSendPresence(false);
        config.setSocketFactory(SSLSocketFactory.getDefault());

        connection = new XMPPTCPConnection(config);
        connection.connect();

        connection.addConnectionListener( new LoggingConnectionListener() );

        // Handle incoming packets
        connection.addPacketListener(new PacketListener() {

            @Override
            public void processPacket(Packet packet) {
                logArea.logMessage( "Received: " + packet.toXML() );
                Message incomingMessage = (Message) packet;
                GcmPacketExtension gcmPacket =
                        (GcmPacketExtension) incomingMessage.
                        getExtension(GCM_NAMESPACE);
                String json = gcmPacket.getJson();
                try {
                    @SuppressWarnings("unchecked")
                    Map<String, Object> jsonObject =
                            (Map<String, Object>) JSONValue.
                            parseWithException(json);

                    // present for "ack"/"nack", null otherwise
                    Object messageType = jsonObject.get("message_type");

                    if (messageType == null) {
                        // Normal upstream data message
                        handleUpstreamMessage(jsonObject);

                        // Send ACK to CCS
                        String messageId = (String) jsonObject.get("message_id");
                        String from = (String) jsonObject.get("from");
                        String ack = createJsonAck(from, messageId);
                        send(ack);
                    } else if ("ack".equals(messageType.toString())) {
                          // Process Ack
                          handleAckReceipt(jsonObject);
                    } else if ("nack".equals(messageType.toString())) {
                          // Process Nack
                          handleNackReceipt(jsonObject);
                    } else if ("control".equals(messageType.toString())) {
                          // Process control message
                          handleControlMessage(jsonObject);
                    } else {
                          logArea.logMessage( "Unrecognised message type: " + 
                                  messageType.toString() );
                    }
                } catch (ParseException e) {
                    logArea.logMessage( "Error parsing JSON " + json );
                } catch (Exception e) {
                    logArea.logMessage( "Failed to process packet" );
                }
            }
        }, new PacketTypeFilter(Message.class));

        // Log all outgoing packets
        connection.addPacketInterceptor(new PacketInterceptor() {
            @Override
                public void interceptPacket(Packet packet) {
                    logArea.logMessage( "Sent: " + packet.toXML());
                }
            }, new PacketTypeFilter(Message.class));

        connection.login(senderId + "@gcm.googleapis.com", apiKey);
    }

    //---------- support classes ----------

    /**
    * XMPP Packet Extension for GCM Cloud Connection Server.
    */
    private static class GcmPacketExtension extends DefaultPacketExtension {

        private final String json;

        public GcmPacketExtension(String json) {
            super( GCM_ELEMENT_NAME, GCM_NAMESPACE);
            this.json = json;
        }

        public String getJson() {
            return json;
        }

        @Override
        public String toXML() {
            return String.format("<%s xmlns=\"%s\">%s</%s>",
                    GCM_ELEMENT_NAME, GCM_NAMESPACE,
                    StringUtils.escapeForXML(json), GCM_ELEMENT_NAME);
        }

        public Packet toPacket() {
            Message message = new Message();
            message.addExtension(this);
            return message;
        }
    }

    class LoggingConnectionListener implements ConnectionListener {

        @Override
        public void connected(XMPPConnection xmppConnection) {
            logArea.logMessage( "Connected." );
        }

        @Override
        public void authenticated(XMPPConnection xmppConnection) {
            logArea.logMessage( "Authenticated." );
        }

        @Override
        public void reconnectionSuccessful() {
            logArea.logMessage( "Reconnecting.." );
        }

        @Override
        public void reconnectionFailed(Exception e) {
            logArea.logMessage( "Reconnection failed.. " + e.getMessage() );
        }

        @Override
        public void reconnectingIn(int seconds) {
            logArea.logMessage( "Reconnecting in " + seconds + " secs" );
        }

        @Override
        public void connectionClosedOnError(Exception e) {
            logArea.logMessage( "Connection closed on error." );
        }

        @Override
        public void connectionClosed() {
            logArea.logMessage( "Connection closed." );
        }
    }
}

// a non-editable combo (drop-down) box for destination addresses
class DestComboBox extends JComboBox<String> {
    // (deleted to save space)
}

// screen panel for sending a message
class SendMessagePanel extends JPanel implements ActionListener, ItemListener {     
    // Message Types
    protected final int MSGTYPE_NOTIFICATION = 1;
    protected final int MSGTYPE_NOTIFICATION_DATA = 2;
    protected final int MSGTYPE_DATA_COLLAPSE = 3;
    protected final int MSGTYPE_DATA_NONCOLLAPSE = 4;

    // log window
    LogTextArea msgs;

    // server class
    CcsServer ccsServer;

    // constructor
    SendMessagePanel( UserList u, LogTextArea m, CcsServer c ) {
        // (deleted to save space)
    }

    // respond to the button
    @Override
    public void actionPerformed(ActionEvent e) {
        String toAddr = "zzzzzz";   // destination address
               // may be device, notification_key, or topic address
        ttl = 2419200;              // time-to-live in seconds

        // what type of message?
        int msgTypeIndex = (--deleted--);

        // create the message
        Map<String, Object> message = new HashMap<String, Object>();
        message.put("to", toAddr);

        if ( msgTypeIndex == MSGTYPE_NOTIFICATION ||
                    msgTypeIndex == MSGTYPE_NOTIFICATION_DATA ||
                    msgTypeIndex == MSGTYPE_DATA_COLLAPSE ) {
            // create a collapse key
            message.put("collapse_key", "ck"+msgTypeIndex );
        }

        message.put("time_to_live", ttl);   
        message.put("message_id", ccsServer.nextMessageId());

        // notification included?
        if ( msgTypeIndex == MSGTYPE_NOTIFICATION ||
                msgTypeIndex == MSGTYPE_NOTIFICATION_DATA ) {

            // create the notification payload
            HashMap<String, String> notePayload = new HashMap<>();
            notePayload.put( "title", "Gcm Push Message Example" );
            notePayload.put( "body", (--deleted--) );
            // identify which notifications should replace older versions
            notePayload.put( "tag", "ntag" + msgTypeIndex );
            notePayload.put( "icon", "@drawable/new_picture" );     // notification icon

            // additional stuff if we also have data
            if ( msgTypeIndex == MSGTYPE_NOTIFICATION_DATA ) {
                // what to do when the user opens the notification
                notePayload.put( "click_action", "OPEN_MAIN_ACTIVITY" );
            }
            message.put( "notification", notePayload );
        }

        // data included?
        if ( msgTypeIndex == MSGTYPE_NOTIFICATION_DATA ||
                    msgTypeIndex == MSGTYPE_DATA_COLLAPSE ||
                    msgTypeIndex == MSGTYPE_DATA_NONCOLLAPSE ) {
            HashMap<String, String> dataPayload = new HashMap<>();

            dataPayload.put( "contents", (--deleted--) );

            message.put("data", dataPayload);
        }

        // actually send the message
        try {
            ccsServer.sendDownstreamMessage( JSONValue.toJSONString(message) );
        } catch (NotConnectedException enc ) {
            msgs.logMessage( "Not connected anymore, echo message is not sent: " + enc.getMessage() );
        }
    }
}

class BorderPanel extends JPanel {
    // (--deleted--)
}

public class GcmPushServer
{
    // (--deleted--)
}