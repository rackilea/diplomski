final Customer customer = Hawk.get("user");
int userID = customer.getID();

final Gson gson = new Gson();
final Type listType = new TypeToken<List<OrderPresenter>>() {}.getType();

final RequestQueue requestQueue = 
Volley.newRequestQueue(context);
final JsonObjectRequest jsObjRequest = new JsonObjectRequest(Request.Method.GET, getURL(FETCH_ORDERS_URI, userID), null,
        new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try {
                    List<OrderPresenter> orders = gson.fromJson(response.getJSONArray("orders").toString(), listType);
                    ArrayList<OrderPresenter> result = new ArrayList<>();

                    for (OrderPresenter record : orders) {
                        Log.i("Statuses_Gson1", record.getStatus());
                        if (record.getStatus().equals("completed")) {
                            result.add(record);
                        }
                     }

                    fetcher.onResponse(result); // this is after the for loop