public class Mapfrag2 extends Fragment{
    public static   GoogleMap map;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.map_fragment_layout, container, false);}

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        map = ((MapFragment)getFragmentManager().findFragmentById(R.id.map)).getMap();

        if (savedInstanceState == null) {
            map.setMyLocationEnabled(true);
            CameraUpdate center = CameraUpdateFactory.newLatLng(new LatLng(30.76793169992044, 1.98180484771729));//moving the map to defined position
            CameraUpdate zoom = CameraUpdateFactory.zoomTo(5);
            map.moveCamera(center);
            markerPoints = new ArrayList<LatLng>();

            map.animateCamera(zoom);
            map.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
                @Override
                public void onInfoWindowClick(Marker marker) {
                   //doing something when pressing marker's bubble
                }
            });
        }

    }









}