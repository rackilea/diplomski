@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    mMapView = Exchanger.mMapView;
    return mMapView;
}

@Override
public void onDestroy() {
    if(mMapView != null) {
        NoSaveStateFrameLayout parentView = (NoSaveStateFrameLayout) mMapView.getParent();
        parentView.removeView(mMapView);
    }
    super.onDestroy();
}