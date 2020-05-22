public class SearchPlaceType extends Activity
{
    String[] itemTypeName ={
            "airport",
            "atm",
            "bank",
            "bus_station",
            "gas_station",
            "hospital",
            "mosque",
            "park",
            "restaurant",
            "university",
            "food"

        };

    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.search_place_type);

        listView = (ListView)findViewById(R.id.typeList);

        listView.setAdapter(new PlaceTypeAdapter(SearchPlaceType.this, itemTypeName));

        listView.setOnItemClickListener(new OnItemClickListener() 
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                    int position, long id) 
            {
                Intent intent = new Intent(SearchPlaceType.this,NearByPlaces.class);

                intent.putExtra("positionOfType", (int)position);

                startActivity(intent);
            }
        });
    }

}