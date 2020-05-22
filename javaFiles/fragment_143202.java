public class CustomInfoWindowAdapter implements GoogleMap.InfoWindowAdapter {
    @Override
    public View getInfoContents(Marker marker) {
        return null;
    }

    @Override
    public View getInfoWindow(final Marker marker) {
        View v = getLayoutInflater().inflate(R.layout.custom_info_window, null);

        TextView title = (TextView)v.findViewById(R.id.title);
        title.setText(marker.getTitle());

        TextView snippet = (TextView)v.findViewById(R.id.snippet);
        snippet.setText(marker.getSnippet());

        return v;
    }
}