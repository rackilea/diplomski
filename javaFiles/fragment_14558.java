public class MainActivity extends AppCompatActivity {
    private List<PojoOfJsonArray> myOptions = new ArrayList<>();
    List<ListItem> consolidatedList = new ArrayList<>();

    private RecyclerView mRecyclerView;
    private Adapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        mRecyclerView.setHasFixedSize(true);

        myOptions.add(new PojoOfJsonArray("name 1", "2016-06-21"));
        myOptions.add(new PojoOfJsonArray("name 2", "2016-06-05"));
        myOptions.add(new PojoOfJsonArray("name 2", "2016-06-05"));
        myOptions.add(new PojoOfJsonArray("name 3", "2016-05-17"));
        myOptions.add(new PojoOfJsonArray("name 3", "2016-05-17"));
        myOptions.add(new PojoOfJsonArray("name 3", "2016-05-17"));
        myOptions.add(new PojoOfJsonArray("name 3", "2016-05-17"));
        myOptions.add(new PojoOfJsonArray("name 2", "2016-06-05"));
        myOptions.add(new PojoOfJsonArray("name 3", "2016-05-17"));

        HashMap<String, List<PojoOfJsonArray>> groupedHashMap = groupDataIntoHashMap(myOptions);


        for (String date : groupedHashMap.keySet()) {
            DateItem dateItem = new DateItem();
            dateItem.setDate(date);
            consolidatedList.add(dateItem);


            for (PojoOfJsonArray pojoOfJsonArray : groupedHashMap.get(date)) {
                GeneralItem generalItem = new GeneralItem();
                generalItem.setPojoOfJsonArray(pojoOfJsonArray);//setBookingDataTabs(bookingDataTabs);
                consolidatedList.add(generalItem);
            }
        }


        adapter = new Adapter(this, consolidatedList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(adapter);


    }

    private HashMap<String, List<PojoOfJsonArray>> groupDataIntoHashMap(List<PojoOfJsonArray> listOfPojosOfJsonArray) {

        HashMap<String, List<PojoOfJsonArray>> groupedHashMap = new HashMap<>();

        for (PojoOfJsonArray pojoOfJsonArray : listOfPojosOfJsonArray) {

            String hashMapKey = pojoOfJsonArray.getDate();

            if (groupedHashMap.containsKey(hashMapKey)) {
                // The key is already in the HashMap; add the pojo object
                // against the existing key.
                groupedHashMap.get(hashMapKey).add(pojoOfJsonArray);
            } else {
                // The key is not there in the HashMap; create a new key-value pair
                List<PojoOfJsonArray> list = new ArrayList<>();
                list.add(pojoOfJsonArray);
                groupedHashMap.put(hashMapKey, list);
            }
        }


        return groupedHashMap;
    }

}