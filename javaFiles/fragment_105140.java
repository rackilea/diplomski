import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.Log;

public class MainActivity extends Activity {

final Context context = this;
MediaPlayer player;
//private Button btn;

public void onCreate(Bundle savedInstanceState) {

    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

     getInit();
    //btn = (Button) findViewById(R.id.button);

    // add PhoneStateListener
    PhoneCallListener phoneCallListener = new PhoneCallListener();
    TelephonyManager telManager = (TelephonyManager) this
            .getSystemService(Context.TELEPHONY_SERVICE);
    telManager.listen(phoneCallListener,
            PhoneStateListener.LISTEN_CALL_STATE);

    // add button listener
    /*btn.setOnClickListener(new OnClickListener() {

        @Override
        public void onClick(View view) {

            Intent phoneCallIntent = new Intent(Intent.ACTION_CALL);
            phoneCallIntent.setData(Uri.parse("tel:123456"));
            startActivity(phoneCallIntent);

        }

    });*/

}

// monitor phone call states
private class PhoneCallListener extends PhoneStateListener {

    String TAG = "LOGGING PHONE CALL";

    private boolean phoneCalling = false;

    @Override
    public void onCallStateChanged(int state, String incomingNumber) {

        if (TelephonyManager.CALL_STATE_RINGING == state) {
            // phone ringing
            Log.i(TAG, "RINGING, number: " + incomingNumber);
        }

        if (TelephonyManager.CALL_STATE_OFFHOOK == state) {
            // active
            Log.i(TAG, "OFFHOOK");

            phoneCalling = true;
            player.start();
        }

        // When the call ends launch the main activity again
        if (TelephonyManager.CALL_STATE_IDLE == state) {

            Log.i(TAG, "IDLE");

            if (phoneCalling) {

                Log.i(TAG, "restart app");

                // restart app
                Intent i = getBaseContext().getPackageManager()
                        .getLaunchIntentForPackage(
                                getBaseContext().getPackageName());

                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);

                phoneCalling = false;
                player.stop();
            }

        }
    }
}
 public void getInit() {
       player = MediaPlayer.create(this, R.raw.a2);
       //player.prepareAsync();
       AudioManager am = (AudioManager) getSystemService(Context.AUDIO_SERVICE);  
       am.setMode(AudioManager.MODE_IN_CALL); 
       am.setSpeakerphoneOn(true);
       //am.setMicrophoneMute(true);
     }
}