public class CustomMapFragment extends SupportMapFragment {

private GoogleMap googleMap;
private List<Marker> markers = new ArrayList<Marker>();

@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
        Bundle savedInstanceState) {
    View view = super.onCreateView(inflater, container, savedInstanceState);
    googleMap = getMap();
    ViewUtils.initializeMargin(getActivity(), view);
    return view;
}

private void addMarkerToMap(LatLng latLng) {
    Marker marker = googleMap.addMarker(new MarkerOptions().position(latLng)
             .title("title")
             .snippet("snippet"));
    markers.add(marker);

}

/**
 * Adds a list of markers to the map.
 */
public void addMarkersToMap(List<LatLng> latLngs) {
    for (LatLng latLng : latLngs) {
        addMarkerToMap(latLng);
    }
}

/**
 * Clears all markers from the map.
 */
public void clearMarkers() {
    googleMap.clear();
    markers.clear();        
}