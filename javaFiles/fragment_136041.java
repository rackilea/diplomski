@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    namesArray.add("Android");
    namesArray.add("Iphone");
    namesArray.add("Windows Phone");
    Bundle bundle = new Bundle();
    bundle.putStringArrayList("valuesArray", namesArray);
    namesFragment myFragment = new namesFragment();
    myFragment.setArguments(bundle);
    fragmentTransaction = getSupportFragmentManager().beginTransaction();
    fragmentTransaction.add(R.id.main_container, myFragment);
    fragmentTransaction.commit();
}