public static class PlaceholderFragment extends Fragment {

    WebView webView;

    public PlaceholderFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_autos,
                container, false);

        // load your webview here using fragment_autos layout.
        webView = (WebView) rootView.findViewById(R.id.webView1);
        webView.loadUrl("http://www.example.com");

        return rootView;
    }
}