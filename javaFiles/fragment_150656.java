public class MainActivity extends Activity
{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        // load the fragment - we only need to do this when the activity is first created
        // - not on a recreation due to screen rotation, etc
        if (savedInstanceState == null) {
            FragmentManager fm = this.getFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.add(R.id.container, new WebViewFragment());
            ft.commit();
        }

    }

    // this could go in a separate file
    public static class WebViewFragment extends Fragment {
        WebView mWebView;

        @Override
        public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            View v = layoutInflater.inflate(R.layout.webviewfrag, null, false);
            this.mWebView = (WebView)v.findViewById(R.id.NewsFeedWbview);
            this.mWebView.loadUrl("https://google.com");
            return v;
        }

    }
}