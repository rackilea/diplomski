public class MainActivity extends AppCompatActivity {

    private Spinner wayPointSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        wayPointSpinner = findViewById(R.id.spinner_way_point);

        // This is the json string returned from server.
        String jsonString = "{\"topic\": \"/waypoints\", \"msg\": {\"waypoints\": [{\"header\": {\"stamp\": {\"secs\": 0, \"nsecs\": 0}, \"frame_id\": \"map\", \"seq\": 0}, \"pose\": {\"position\": {\"y\": -140.901899144836, \"x\": 44.36469369653882, \"z\": 0.0}, \"orientation\": {\"y\": 0.0, \"x\": 0.0, \"z\": 0.5062775131960053, \"w\": 0.8623706161692133}}, \"name\": \"A\"}, {\"header\": {\"stamp\": {\"secs\": 0, \"nsecs\": 0}, \"frame_id\": \"map\", \"seq\": 0}, \"pose\": {\"position\": {\"y\": -102.30524463734227, \"x\": 51.282396271771304, \"z\": 0.0}, \"orientation\": {\"y\": 0.0, \"x\": 0.0, \"z\": 0.6926372547579506, \"w\": 0.721286096719859}}, \"name\": \"B\"}]}, \"op\": \"publish\"}";

        // This will convert the json string to list of WayPoint
        List<WayPoint> wayPoints = getWayPointListFromJsonString(jsonString);

        // Create adapter for spinner
        SpinnerAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, wayPoints);

        wayPointSpinner.setAdapter(adapter);
        wayPointSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int p, long id) {
                WayPoint wayPoint = (WayPoint) parent.getItemAtPosition(p);

                // Process position here
                Position position = wayPoint.pose.position;

                // Process orientation here
                Orientation orientation = wayPoint.pose.orientation;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }
}