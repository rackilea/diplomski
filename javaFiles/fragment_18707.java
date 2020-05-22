public class PhotosActivity extends Activity {

  // Use a string constant to "tag" log statements that belong to the same
  // feature/module of your app. This activity does something with "photos" so
  // use that as a tag. It's the first parameter to Android's Log methods.
  private static final String TAG = "photos";

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState); // Always call super.onCreate() first.
    setContentView(R.layout.photos_layout); // Then load the layout.

    // Find textView3 in layout and set it's text to HTML code.
    // There's no need to create a new TextView() here.
    TextView textView = (TextView) findViewById(R.id.textView3);
    textView.setText(getHtmlCode());
  }

  // Structure your code. If it's a larger block that does one thing,
  // extract it into a method.
  private String getHtmlCode() {
    try {
      Document doc = Jsoup.connect("http://www.example.com/").get();
      Element content = doc.select("a").first();
      return content.text();
    } catch (IOException e) {
      // Never e.printStackTrace(), it cuts off after some lines and you'll
      // lose information that's very useful for debugging. Always use proper
      // logging, like Android's Log class, check out
      // http://developer.android.com/tools/debugging/debugging-log.html
      Log.e(TAG, "Failed to load HTML code", e);
      // Also tell the user that something went wrong (keep it simple,
      // no stacktraces):
      Toast.makeText(this, "Failed to load HTML code",
          Toast.LENGTH_SHORT).show();
    }
  }
}