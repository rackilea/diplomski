public class OriginActivity extends AppCompatActivity{

    CustomPhoneStateListener customPhoneStateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_origin);

        /**** Other Code ****/

    }

    protected void onResume() {
        super.onResume();

        //Here, we start the listener!!!
        TelephonyManager tManager = (TelephonyManager)getSystemService(TELEPHONY_SERVICE);
        customPhoneStateListener = new CustomPhoneStateListener(this);
        tManager.listen(customPhoneStateListener, PhoneStateListener.LISTEN_SIGNAL_STRENGTHS);
        Log.d(TAG, "onResume");
    }

    protected void onPause() {
        super.onPause();

        //Here, we stop the listener!!!
        TelephonyManager tManager = (TelephonyManager)getSystemService(TELEPHONY_SERVICE);
        tManager.listen(customPhoneStateListener, PhoneStateListener.LISTEN_NONE);
        customPhoneStateListener = null;
    }

}