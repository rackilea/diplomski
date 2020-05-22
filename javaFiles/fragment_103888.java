public class WebViewFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener {

    private static final String TAG = WebViewFragment.class.getSimpleName();
    WebView mWebView;
    private MenuType mMenuType;
    private String mUrl;
    SwipeRefreshLayout mPullToLoad;


    public static WebViewFragment newInstance(MenuType menuType) {
       WebViewFragment fragment = new WebViewFragment();
        fragment.setMenuType(menuType);
        return fragment;
    }

    public void setMenuType(MenuType menuType) {
        this.mMenuType = menuType;
    }

    public WebViewFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        if (mMenuType == MenuType.ABOUTUS) {
            mUrl = " valid about us url";
        } else if (mMenuType == MenuType.FAQS) {
            mUrl = " valid FAQS url";
        } else if (mMenuType == MenuType.TERMSANDCONDITION) {
            mUrl = "valid terms and conditions url";
        }

        View view = inflater.inflate(R.layout.fragment_webview,
                container, false);
//      initialize views here.
        int progressColor1 = ContextCompat.getColor(mContext, R.color.primary_color);
        int progressColor2 = ContextCompat.getColor(mContext, R.color.primary_color_dark);
        int progressColor3 = ContextCompat.getColor(mContext, R.color.dark_blue);
        int progressColor4 = ContextCompat.getColor(mContext, R.color.light_orange);

        mPullToLoad.setColorSchemeColors(progressColor2,progressColor3,progressColor4,progressColor1);
        mPullToLoad.setOnRefreshListener(this);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDisplayZoomControls(true);
        webSettings.setSupportZoom(true);
        webSettings.setUseWideViewPort(true);
        webSettings.setBuiltInZoomControls(true);

        mWebView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                showRefreshDialog();
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                dismissRefreshDialog();
            }
        });
        mWebView.loadUrl(mUrl);
    }



    @Override
    public void onRefresh() {

            if(mWebView !=null) {
                mWebView.loadUrl(mUrl);

        }

    }


    public void showRefreshDialog() {
        mPullToLoad.post(new Runnable() {
            @Override
            public void run() {
                if(mPullToLoad != null)
                    mPullToLoad.setRefreshing(true);
            }
        });
    }


    public void dismissRefreshDialog() {
        if(mPullToLoad!=null && mPullToLoad.isShown() )
            mPullToLoad.setRefreshing(false);
    }
 }