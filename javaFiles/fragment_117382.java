public PlaceholderFragment() {
    }

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static PlaceholderFragment newInstance(int sectionNumber) {
        PlaceholderFragment fragment = new PlaceholderFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                         Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_programma, container, false);
        WebView heroespage = (WebView) rootView.findViewById(R.id.progwebview);
        WebSettings webSettings = heroespage.getSettings();
        webSettings.setJavaScriptEnabled(true);
        heroespage.loadUrl("http://www.google.it/");

        return rootView;
    }
}