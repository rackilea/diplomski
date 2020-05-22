public class MyCustomAdapterForItems implements GoogleMap.InfoWindowAdapter {

    private final View myContentsView;

    MyCustomAdapterForItems() {
        myContentsView = getLayoutInflater().inflate(
                R.layout.info_window, null);
    }

    @Override
    public View getInfoWindow(Marker marker) {
        return null;
    }

    @Override
    public View getInfoContents(Marker marker) {

        TextView tvTitle = ((TextView) myContentsView
                .findViewById(R.id.txtTitle));
        TextView tvSnippet = ((TextView) myContentsView
                .findViewById(R.id.txtSnippet));

        tvTitle.setText(clickedClusterItem.getTitle());
        tvSnippet.setText(clickedClusterItem.getSnippet());

        return myContentsView;
    }
}