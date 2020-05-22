SupportMapFragment supportMapFragment;
if (Build.VERSION.SDK_INT < 21) {
    supportMapFragment = (SupportMapFragment) getActivity()
        .getSupportFragmentManager().findFragmentById(R.id.map);
} else {
    supportMapFragment = (SupportMapFragment) getActivity()
        .getChildFragmentManager().findFragmentById(R.id.map);
}
supportMapFragment.getMapAsync(this);