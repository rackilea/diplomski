@Override
public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
super.onViewCreated(view, savedInstanceState);
FragmentManager fm = getChildFragmentManager();
SupportMapFragment mapFragment = (SupportMapFragment) fm.findFragmentByTag("mapFragment");
if (mapFragment == null) {
    mapFragment = new SupportMapFragment();
    FragmentTransaction ft = fm.beginTransaction();
    ft.add(R.id.mapFragmentContainer, mapFragment, "mapFragment");
    ft.commit();
    fm.executePendingTransactions();
  }
   mapFragment.getMapAsync(callback);
}