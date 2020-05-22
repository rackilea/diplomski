public class InfoAdapter implements GoogleMap.InfoWindowAdapter {
    LayoutInflater inflater = null;
    private TextView textViewstopName;
    private TextView arrivalTime;
    public InfoAdapter(LayoutInflater inflater) {
        this.inflater = inflater;
    }
    @Override
    public View getInfoWindow(Marker marker) {
        if (marker != null) {
            if(markerPlaces.containsKey(marker.getId())) {
            ... //Add new inflater here.
            } //checks if the marker is part of the Position marker or POI marker.
            else{
                View v = inflater.inflate(R.layout.businfo_layout, null);
                textViewstopName = (TextView) v.findViewById(R.id.businfo);
                textViewstopName.setText(marker.getTitle());
                arrivalTime = (TextView) v.findViewById(R.id.arrivalinfo);
                arrivalTime.setText(marker.getSnippet());
                return (v);
            }
        }
        return null;
    }
    @Override
    public View getInfoContents(Marker marker) {
        return (null);
    }
}