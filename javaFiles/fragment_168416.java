@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
        Bundle savedInstanceState) {
    View rootView = inflater.inflate(R.layout.fragment_main, container, false);

    TabHost tabHost = (TabHost) rootView.findViewById(R.id.tabHost);
    tabHost.setup();

    TabHost.TabSpec spec1, spec2, spec3;

    spec1 = tabHost.newTabSpec("spec1");
    spec1.setContent(R.id.tab1);
    spec1.setIndicator("Tab1");
    tabHost.addTab(spec1);

    spec2 = tabHost.newTabSpec("spec2");
    spec2.setContent(R.id.tab2);
    spec2.setIndicator("Tab2");
    tabHost.addTab(spec2);

    spec3 = tabHost.newTabSpec("spec3");
    spec3.setContent(R.id.tab3);
    spec3.setIndicator("Tab3");
    tabHost.addTab(spec3);

   return rootView;
  }