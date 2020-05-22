public class showMaps extends AbstractMapActivity {

    private GoogleMap map;   


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        if (readyToGo()) {
            setContentView(R.layout.showmaps);

            SupportMapFragment mapFrag = (SupportMapFragment) getSupportFragmentManager()
                    .findFragmentById(R.id.map);    
            map = mapFrag.getMap();   
        }
    }

}