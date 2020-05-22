public final String RSSFEEDOFCHOICE = "http://www.deals2buy.com/rssgen/tech.xml";
public final String tag = "RSSReader";
private RSSFeed feed = null;
private Handler handler = new Handler();
private ProgressDialog dialog;

/** Called when the activity is first created. */

public void onCreate(Bundle icicle) {
    super.onCreate(icicle);
    setContentView(R.layout.main);
    dialog = ProgressDialog.show(RSSReader.this, "Loading",
            "Loading, please wait..");
    Thread t = new Thread() {
        public void run() {
            feed = getFeed(RSSFEEDOFCHOICE);
            handler.post(new Runnable() {
                public void run() {
                    dialog.dismiss();
                    UpdateDisplay();
                };
            });
        }
    };

    t.start();
}