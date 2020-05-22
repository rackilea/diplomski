@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.viewgroup_activity_layout);

    if (savedInstanceState == null) {
        getFragmentManager().beginTransaction()
            .add(R.id.container_for_your_fragment, new MyFragment())
            .commit();
    }