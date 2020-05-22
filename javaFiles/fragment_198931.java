public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    View drawer = inflater.inflate(R.layout.fragment_pending, container, false);

    pendingnullorder = (TextView) drawer.findViewById(R.id.pendingnullorder);

    recyclerView = (RecyclerView) drawer.findViewById(R.id.pending);
    progressBar = (ProgressBar) drawer.findViewById(R.id.progressBar);
    /*recyclerView.setVisibility(View.GONE);*/
    progressBar.setVisibility(ProgressBar.VISIBLE);

    recyclerView.setHasFixedSize(true);
    recyclerView.setLayoutManager(new LinearLayoutManager(inflater.getContext()));

    orderLists = new ArrayList<>();

    getPendingData();

    adapter = new OrderListAdapter(orderLists, inflater.getContext());
    recyclerView.setAdapter(adapter);

    updateUI();

    return drawer;
}

private void getPendingData() {
    String token = SharedPreferencesManager.readPreferenceString("token", "D/N");
    JSONObject progressData = new JSONObject();
    try{
        progressData.put("token", token);
        JsonObjectRequest progressObject = new JsonObjectRequest(1, Common.OrderDetails + "progress", progressData, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject progressResponse) {
                Log.d("Responseprogress", progressResponse.toString());
                try {
                    int status = progressResponse.getInt("status");
                    if(status == 1) {
                        progressOrderProgress(progressResponse);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
                Log.d("Response", "PROGRESS ERROR");
            }
        });
        progressObject.setShouldCache(false);
        ServiceBellApp.getInstance().addToRequestQueue(progressObject);
    }
    catch (JSONException localJSONException){
        localJSONException.printStackTrace();
        return;
    }
}

private void progressOrderProgress(JSONObject progressResponse) throws JSONException {
    JSONArray result = progressResponse.getJSONArray("orderdata");
    for(int i=0; i<result.length(); i++){
        OrderList orderListModule = new OrderList();
        JSONObject orderData = null;
        try {
            orderData = result.getJSONObject(i);
            orderListModule.setPackage_name(orderData.getString("name"));
            orderListModule.setOrderdate(orderData.getString("date"));
            orderListModule.setServicedate(orderData.getString("service"));
            orderListModule.setServicetime(orderData.getString("time"));
            orderListModule.setOrderid(orderData.getString("id"));
            orderListModule.setOrdstatus(orderData.getString("status"));
            orderListModule.setOrderamount(orderData.getInt("ramount"));
        }catch (JSONException e) {
            e.printStackTrace();
        }
        orderLists.add(orderListModule);
    }
    swipeRefreshLayout.setRefreshing(false);
    adapter.notifyDataSetChanged();
    updateUI();
}

private void updateUI() {
    if (adapter.getCount() == 0) {
        pendingnullorder.setVisibility(View.VISIBLE);
        recyclerView.setVisibility(View.GONE);
    } else {
        pendingnullorder.setVisibility(View.GONE);
        recyclerView.setVisibility(View.VISIBLE);
    }
}