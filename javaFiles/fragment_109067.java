public class CallReceiver extends BroadcastReceiver {

MediaRecorder recorder;
TelephonyManager telManager;
boolean recordStarted;
private Context ctx;
static boolean status = false;
String phoneNumber;

public static SharedPreferences preferences;
boolean enabled;
private static Date date;
Boolean isIncoming;
String isInOrOut;
private static String dateStr;
static long start_time, end_time;

String lastCallnumber;

@Override
public void onReceive(Context context, Intent intent) {

    ctx = context;
    String action = intent.getAction();

    preferences = context.getSharedPreferences("Numbers", Context.MODE_PRIVATE);
    enabled = preferences.getBoolean("enabled", false);

    date = new Date();

    dateStr = date.getHours() + ":" + date.getMinutes() + ":" + date.getSeconds();

    if (enabled) {
        if (status == false) {
            try {
                recorder = new MediaRecorder();
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            Bundle extras = intent.getExtras();
            if (extras != null) {
                String state = extras.getString(TelephonyManager.EXTRA_STATE);
                if (state.equals(TelephonyManager.EXTRA_STATE_RINGING)) {
                    incomingcallrecord(action, context);
                } else if (state.equals(TelephonyManager.EXTRA_STATE_OFFHOOK)) {
                    incomingcallrecord(action, context);
                }
            }
        } else {
            status = false;
        }
    }
}

private void incomingcallrecord(String action, Context context) {
    // TODO Auto-generated method stub
    if (action.equals("android.intent.action.PHONE_STATE")) {
        telManager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        telManager.listen(phoneListener, PhoneStateListener.LISTEN_CALL_STATE);
    }
}

private final PhoneStateListener phoneListener = new PhoneStateListener() {
    @Override
    public void onCallStateChanged(int state, String incomingNumber) {

        Log.d("calling number", "calling number" + incomingNumber);
        try {
            switch (state) {
                case TelephonyManager.CALL_STATE_RINGING: {
                    Log.e("CALL_STATE_RINGING", "CALL_STATE_RINGING");

                    isIncoming = true;

                    recorder.setAudioSource(MediaRecorder.AudioSource.VOICE_CALL);
                    recorder.setOutputFormat(MediaRecorder.OutputFormat.MPEG_4);
                    recorder.setAudioEncoder(MediaRecorder.AudioEncoder.AAC);

                    Log.e("incoming", "incoming call" + incomingNumber);

                    phoneNumber = incomingNumber;

                    File file = createDirIfNotExists();
                    recorder.setOutputFile(file.getAbsolutePath());

                    recorder.prepare();
                    Thread.sleep(1000);
                    recorder.start();
                    recordStarted = true;
                    status = true;
                    Log.e("Record start", " Start");

                    Log.d("calling number ringing", "" + incomingNumber);

                    break;
                }

                case TelephonyManager.CALL_STATE_OFFHOOK: {
                    Log.e("CALL_STATE_OFFHOOK", "CALL_STATE_OFFHOOK");

                    isIncoming = false;

                    recorder.setAudioSource(MediaRecorder.AudioSource.VOICE_CALL);
                    recorder.setOutputFormat(MediaRecorder.OutputFormat.MPEG_4);
                    recorder.setAudioEncoder(MediaRecorder.AudioEncoder.AAC);

                    Log.e("outgoing", "outgoing call" + lastCallnumber);

                    File file = createDirIfNotExists();
                    recorder.setOutputFile(file.getAbsolutePath());

                    recorder.prepare();
                    Thread.sleep(1000);
                    recorder.start();
                    recordStarted = true;
                    status = true;
                    Log.e("Record start", " Start");

                    Log.d("calling number offhook", "" + lastCallnumber);

                    break;
                }

                case TelephonyManager.CALL_STATE_IDLE: {

                    Log.e("CALL_STATE_IDLE", "CALL_STATE_IDLE");
                    if (recordStarted) {
                        recorder.stop();
                        recorder.reset();
                        recorder.release();
                        Log.e("Record stop", " stop");
                        recorder = null;
                        recordStarted = false;
                    }

                    if (isIncoming) {

                        isInOrOut = "in";

                        ContentValues values = new ContentValues();
                        values.put(CallRecorderSQLite.FeedEntry.COLUMN_1_TIME, dateStr);
                        values.put(CallRecorderSQLite.FeedEntry.COLUMN_2_NUMBER, phoneNumber);
                        values.put(CallRecorderSQLite.FeedEntry.COLUMN_3_INOUT, isInOrOut);
                        Activity_Landing.dbWritable.insert(CallRecorderSQLite.FeedEntry.TABLE_NAME, null, values);

                    } else {

                        isInOrOut = "out";
                        Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {

                            @Override
                            public void run() {
                                Log.i("CallLogDetailsActivity", "Getting Log activity...");
                                String[] projection = new String[]{CallLog.Calls.NUMBER};
                                if (ActivityCompat.checkSelfPermission(ctx, Manifest.permission.READ_CALL_LOG) != PackageManager.PERMISSION_GRANTED) {
                                    // TODO: Consider calling
                                    return;
                                }
                                Cursor cur = ctx.getContentResolver().query(CallLog.Calls.CONTENT_URI, projection, null, null, CallLog.Calls.DATE + " desc");
                                cur.moveToFirst();
                                lastCallnumber = cur.getString(0);

                                ContentValues values = new ContentValues();
                                values.put(CallRecorderSQLite.FeedEntry.COLUMN_1_TIME, dateStr);
                                values.put(CallRecorderSQLite.FeedEntry.COLUMN_2_NUMBER, lastCallnumber);
                                values.put(CallRecorderSQLite.FeedEntry.COLUMN_3_INOUT, isInOrOut);
                                Activity_Landing.dbWritable.insert(CallRecorderSQLite.FeedEntry.TABLE_NAME, null, values);
                            }
                        }, 500);
                    }

                    Log.d("calling number idle", "" + incomingNumber);
                    break;
                }
                default: {
                }
            }
        } catch (Exception ex) {

            Log.e("Exception ------", "" + ex.toString());
        }
    }
};

public File createDirIfNotExists() {

    File folder = new File(Environment.getExternalStorageDirectory() + "/PhoneCallRecording");
    if (!folder.exists()) {
        if (!folder.mkdirs()) {
            Log.e("TravellerLog :: ", "folder is created");
        }
    }
    File file = new File(folder, dateStr + ".amr");
    try {
        if (!file.exists()) {
            if (file.createNewFile()) {
                Log.e("TravellerLog :: ", "file is created");
            }
        }
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    return file;
}