public class NearByPlaces extends Activity
{
    ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();

    ListView listView;

    int positionOfType = 0;

    Context context;

    MyLocation myLocation;

    double current_location_lat, current_location_lng;

    public static String latStr = "";
    public static String longStr = "";

    public static LatLng myLatLng = null;

    public static LatLng destinationLatLng = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.near_by_places);

        context = NearByPlaces.this;

        Bundle extras = getIntent().getExtras();

        if(extras!=null)
        {
            positionOfType = extras.getInt("positionOfType", positionOfType);
        }

        listView = (ListView)findViewById(R.id.nearbyList);

        myLocation = new MyLocation(context);

        if (myLocation.isLocationAvailable() && myLocation.getUserLocation() != null)
        {
            current_location_lat =  myLocation.getUserLocation().latitude;

            current_location_lng =  myLocation.getUserLocation().longitude;

            latStr = current_location_lat + "";

            longStr = current_location_lng + "";

            myLatLng = new LatLng(current_location_lat, current_location_lng);

            //url = url_part1 + latStr + "," + longStr + url_part2;

            Log.d("LATITUDE", String.valueOf(current_location_lat));

            Log.d("LONGITUDE", String.valueOf(current_location_lng));


            new PlaceTask(context, positionOfType, latStr, longStr, new onTaskDoneListener() 
            {
                @Override
                public void onTaskDone(JSONObject jsonObject) 
                {
                    if(jsonObject!=null)
                    {
                        try 
                        {
                            JSONObject obj = jsonObject;//new JSONObject(jsonObject);

                            String status = obj.getString("status");

                            if(status.equals("OK"))
                            {
                                JSONArray arr = obj.getJSONArray("results");

                                for(int i = 0; i < arr.length(); i++)
                                {
                                    double lat = arr.getJSONObject(i).getJSONObject("geometry").getJSONObject("location").getDouble("lat");

                                    double lng = arr.getJSONObject(i).getJSONObject("geometry").getJSONObject("location").getDouble("lng"); 

                                    String place_name = arr.getJSONObject(i).getString("name");

                                    String vicinity = arr.getJSONObject(i).getString("vicinity");

                                    HashMap<String, String> map = new HashMap<String,String>();

                                    map.put("placeName", place_name);

                                    map.put("vicinity", vicinity);

                                    map.put("lat", String.valueOf(lat));

                                    map.put("lng", String.valueOf(lng));

                                    list.add(map);
                                }

                                NearByPlaceAdapter adapter = new NearByPlaceAdapter(context, list);

                                listView.setAdapter(adapter);
                            }
                        } 
                        catch (JSONException e) 
                        {
                            e.printStackTrace();
                        }
                    }
                    else
                    {
                        Toast.makeText(context, "Response is Null", Toast.LENGTH_LONG).show();
                    }

                }
            }).execute();

            //showSearchDialog(map);    
        }               
        else
        {
            Toast.makeText(context, "Please Enable Location Services and GPS From your Device", 
                    Toast.LENGTH_LONG).show();
        }       

        listView.setOnItemClickListener(new OnItemClickListener() 
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                    int position, long id) 
            {
                HashMap<String, String> map = list.get(position);

                Intent intent = new Intent(context,DirectionActivity3.class);

                destinationLatLng = new LatLng(Double.valueOf(map.get("lat")), Double.valueOf(map.get("lat")));

                startActivity(intent);
            }
        });
    }

}