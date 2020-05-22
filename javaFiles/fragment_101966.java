//Static String to identify the send parameter, without this this you have to set the exact same string twice.
public final static String SESSION_ID = "com.example.your.long.appname.SESSION_ID";

//sendMessage method is called for some reason in your class that you define (e.g user onClick)
public void sendMessage(View view) {
    //Create an Intent
    Intent intent = new Intent(this, Activity2.class);
    //put the sessionID as extra intent.
    intent.putExtra(SESSION_ID, sessionID);
    //Start Activity2 with the intent.
    startActivity(intent);
}