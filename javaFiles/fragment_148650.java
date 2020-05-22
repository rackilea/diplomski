@Override
public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                         Bundle savedInstanceState) {
    View rootView = inflater.inflate(R.layout.fragment_hira, container, false);

    // To access the views, you need to prefix them with the rootView like this
    web = (WebView) rootView.findViewById(R.id.webView);
    progressBar = (ProgressBar) rootView.findViewById(R.id.progressBar);
    logo = (ImageView) rootView.findViewById(R.id.logo);
    bg = (ImageView) rootView.findViewById(R.id.bg);
    text = (TextView) rootView.findViewById(R.id.text); 

    web.setWebViewClient(new hira());
    web.loadUrl("http://example.com/");
    web.getSettings().setJavaScriptEnabled(true);

    return rootView;
}