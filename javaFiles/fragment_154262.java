GoogleMap googlemapa;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.buscarcontrincante);

    SupportMapFragment maps = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);

    googlemapa = maps.getMap();
    googlemapa.setMyLocationEnabled(true);
    googlemapa.setMapType(GoogleMap.MAP_TYPE_HYBRID);
    googlemapa.getUiSettings().setCompassEnabled(true);
    googlemapa.getUiSettings().setZoomControlsEnabled(true);
    googlemapa.getUiSettings().setAllGesturesEnabled(true);

    new RetreiveFeedTask().execute();
}

class RetreiveFeedTask extends AsyncTask<Void, Void, String[][]> {

    @Override
    protected String[][] doInBackground(Void... args) {
        // Execute the HTTP request on background task
        Datos com = new Datos(); // File Datos.java
        return com.Ubic();
    }

    @Override
    protected void onPostExecute(String[][] latlon) {
        double latitud;
        double longitud;
        String nombre;

        // Update the UI
        for (int i = 0; i < latlon.length - 1; i++) {
            latitud = Double.parseDouble(latlon[i][0]);
            longitud = Double.parseDouble(latlon[i][3]);
            nombre = (latlon[i][2]);

            LatLng posicion = new LatLng(latitud, longitud);

            googlemapa.addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.drawable.icono_canchas)).position(posicion).title(nombre));

        }
    }
}