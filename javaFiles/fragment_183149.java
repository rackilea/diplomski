class SmsFilter extends BroadcastReceiver {
@Override
public void onReceive(Context context, Intent intent) {
    if (intent != null){
        String action = intent.getAction();

        if (action.equals("android.provider.Telephony.SMS_RECEIVED")){
           Bundle extras = intent.getExtras();

            if (extras != null){
                AudioManager am = (AudioManager)context.getSystemService(Context.AUDIO_SERVICE);
                am.setRingerMode(AudioManager.RINGER_MODE_SILENT);
            }
        }
    }
}