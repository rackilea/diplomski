protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);

setContentView(R.layout.activity_main);

//adding the fragment
FragmentManager fm = getFragmentManager();
FragmentTransaction ft = fm.beginTransaction();

FragOne newFrag = new FragOne();
ft.add(R.id.myContainerFrameLayout, newFrag);
ft.commit();