public class BookingHistoryFragment extends Fragment {

  String parsed; //Defined Globally
  private TextView bookingHistoryTV;
  private RequestQueue mQueue;

  @Nullable
  @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, 
  @Nullable Bundle savedInstanceState) {


  View view = inflater.inflate(R.layout.fragment_booking_history, container, false);
  bookingHistoryTV = view.findViewById(R.id.bookingHistoryTV);
  jsonParse();

  return inflater.inflate(R.layout.fragment_booking_history, container, false);
  }

  private void jsonParse() {
  String url = "http://178.128.166.68/getBookingHistory.php";

  JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
        new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray jsonArray = response.getJSONArray("bookingHistory");

                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject bookingHistory = jsonArray.getJSONObject(i);

                        String fromLocality = 
                         bookingHistory.getString("fromLocality");
                        String toLocality = bookingHistory.getString("toLocality");
                        double cost = bookingHistory.getDouble("cost");
                        String date = bookingHistory.getString("date");

                        parsed = fromLocality + " | " + toLocality + " | " + String.valueOf(cost) + " | " + date + "\n\n";
                    }

                  bookingHistoryTV.setText(parsed); //setText outside of For Loop

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
    @Override
    public void onErrorResponse(VolleyError error) {
        error.printStackTrace();
    }
});

  //creating a request queue
    RequestQueue requestQueue = Volley.newRequestQueue(this);

 //adding the string request to request queue
    mQueue.add(request);
   }
 }