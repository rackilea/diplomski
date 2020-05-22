public class FragmentPage extends Fragment {

    protected MainActivity mainActivity;

    // layout resource
    protected int layoutResource;

    // view
    protected View rootView;

    //Admob
    protected AdView adBanner;
    protected int adBannerResource;
    protected int adBannerLayoutResource;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        onCreate(inflater, container);

        return rootView;
    }

    // manage common onCreate things
    protected void onCreate(LayoutInflater inflater, ViewGroup container)
    {
        rootView = inflater.inflate(layoutResource, container, false);

        // admob banner
        adBanner = (AdView) rootView.findViewById(adBannerResource);
        adBanner.setAdListener(new AdListener() {

            @Override
            public void onAdLoaded() {
            }

            @Override
            public void onAdOpened() {
            }

            @Override
            public void onAdClosed() {
                newAdBannerRequest();
            }

            @Override
            public void onAdFailedToLoad(int errorCode) {
                newAdBannerRequest();
            }

            @Override
            public void onAdLeftApplication() {
            }
        });

        if(mainActivity.showAdBanners())
        {
            newAdBannerRequest();
            showAdBanner();
        }
        else
            hideAdBanner();
    }


    // ADMOB
    public void newAdBannerRequest()
    {
        AdRequest request = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)        // All emulators
                .addTestDevice("XXXXXXXXXXXXXXXXXXXXXXXXXX")  // My Galaxy Nexus test phone
                .build();
        adBanner.loadAd(request);
    }

    public void showAdBanner()
    {
        GridLayout adBannerLayout = (GridLayout) rootView.findViewById(adBannerLayoutResource);
        if(adBannerLayout.getVisibility() == GridLayout.GONE)
            adBannerLayout.setVisibility(GridLayout.VISIBLE);
    }

    public void hideAdBanner()
    {
        GridLayout adBannerLayout = (GridLayout) rootView.findViewById(adBannerLayoutResource);
        if(adBannerLayout.getVisibility() == GridLayout.VISIBLE)
            adBannerLayout.setVisibility(GridLayout.GONE);
    }


    // GETTERS
    public AdView getAdBanner() { return adBanner;}
    public View getRootView() { return rootView;}


    // SETTERS
    public void setMainActivity(MainActivity mainActivity) {this.mainActivity = mainActivity;}
    public void setLayoutResource(int layoutResource){this.layoutResource = layoutResource;}
    public void setAdBannerResource(int adBannerResource){this.adBannerResource = adBannerResource;}
    public void setAdBannerLayoutResource(int adBannerLayoutResource){this.adBannerLayoutResource = adBannerLayoutResource;}
}