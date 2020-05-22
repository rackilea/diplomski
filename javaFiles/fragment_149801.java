map.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
    @Override
    public void onInfoWindowClick(Marker marker) {
        Intent intent = new Intent(GoogleMapsFragment.this.getActivity(), DetailedInformation.class);
        intent.putExtra("title", marker.getTitle());
        intent.putExtra("snippet", marker.getSnippet());
        startActivity(intent);
    }
});