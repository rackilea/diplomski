PlaceholderFragment fragment;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_grupos);

    if(savedInstanceState == null)
    {
        fragment = new PlaceHolderFragment();
        fragment.setTag(R.id.myfragmentId);
        getFragmentManager().beginTransaction()
            .add(R.id.container, fragment).commit();
    }
    else
    {
        if(fragment == null)
        {
            fragment = (PlaceholderFragment) getFragmentManager().findFragmentByTag(R.id.myfragmentId);
        }
    }
}