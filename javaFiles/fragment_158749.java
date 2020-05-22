public class QrScann {

static final String ACTION_SCAN = "com.google.zxing.client.android.SCAN";
private MainActivity mContext;
public QrScann(MainActivity context) {
   mContext = context;
}

public void Scanner(View v) {
    try {
        Intent intent = new Intent(ACTION_SCAN);
        intent.putExtra("SCAN_MODE", "QR_CODE_MODE");
        mContext.startActivityForResult(intent, 0);
    } catch (ActivityNotFoundException anfe) {
        //show dialog is deprecated , try DialogFragments
        mContext.showDialog(QrScann.this, "No Scanner Found", "Download a scanner code activity?", "Yes", "No").show();
    }
}