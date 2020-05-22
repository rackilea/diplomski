DataListAdapter dataListAdapter;
   ArrayList<DataObject> dataArrayList;
   @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        _activity = this;

        //edit: declare your arraylist and adapter here
        dataArrayList = new ArrayList<DataObject>();
        dataListAdapter = new DataListAdapter(dataArrayList);


        lv = (ListView) findViewById(R.id.listView1);
        View footerView = ((LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.loading_view, null, false);
        this.lv.addFooterView(footerView);

        if (isOnline(_activity)) {
            new LoadJsonData().execute();
            scrollNotifyChange();
        }

    }
    ......
    ....... 

    public void onPostExecute(String result) {
        try {
//            progress.dismiss();
            //dataArrayList = new ArrayList<DataObject>(); //edit 
            JSONObject dataJsontObject = new JSONObject(result);
            JSONArray dataJsonArray = dataJsontObject.getJSONArray("data");
            for (int i = 0; i < dataJsonArray.length(); i++) {
                JSONArray dataSubArray = dataJsonArray.getJSONArray(i);

                dataObject = new DataObject();
                dataObject.setName((String) dataSubArray.get(0));
                dataObject.setType((String) dataSubArray.get(1));
                dataObject.setProfession((String) dataSubArray.get(2));
                dataObject.setCountry((String) dataSubArray.get(3));
                dataObject.setCurrency((String) dataSubArray.get(5));
                dataArrayList.add(dataObject);
            }
            //edit: your creating new adapter for every execution
            //dataListAdapter = new DataListAdapter(dataArrayList);
            //dataListAdapter.add(dataObject);
//            lv.setAdapter(dataListAdapter);
//            dataListAdapter.add(dataObject);
            dataListAdapter.notifyDataSetChanged();
            //lv.setAdapter(dataListAdapter);
            lv.smoothScrollToPosition(dataListAdapter.getCount());

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }