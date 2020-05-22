public class TestClipboardServiceActivity extends Activity {
    @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        startService(new Intent(this, MyClipboardService.class));

        // Forced the app to be destroyed intentionally.
        finish();
    }
}

/**
 * Clipboard Service. It will clear the clipboard after 60 seconds.
 */
public class MyClipboardService extends Service {

    public class LocalBinder extends Binder {
        MyClipboardService getService() {
            return MyClipboardService.this;
        }
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i("MyClipboardService", "Received start id " + startId + ": " + intent);

        // Remember, this is executed in the main thread.
        new Handler().postDelayed(new Runnable() {
            @Override public void run() {
                clearClipboard();
            }
        }, 6000);

        return START_STICKY;
    }


    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }

    private final IBinder mBinder = new LocalBinder();

    /**
     * Clears the clipboard.
     */
    private void clearClipboard() {
        ClipboardManager myClipboard =
            (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
        if (myClipboard != null) {
            myClipboard.setPrimaryClip(ClipData.newPlainText(null, "");
        }
    }
}