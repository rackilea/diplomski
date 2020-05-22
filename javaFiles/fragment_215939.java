public class MainActivity extends ActionBarActivity {

private ListView mListView;
private TextView mTextView;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    mListView = (ListView) findViewById(R.id.listView1);
    mTextView = (TextView) findViewById(R.id.textView1);
}

public void onClick(View v) {
    new NewRequest().execute();
}

public class NewRequest extends AsyncTask<String, Integer, JSONObject> {

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected JSONObject doInBackground(String... params) {

        try {
            DefaultHttpClient httpClient = new DefaultHttpClient();

            HttpGet httpGet = new HttpGet(
                    "http://firstchoicefood.in/fcfapiphpexpert/phpexpert_order_details.php?order_identifyno=FCF2");

            HttpResponse httpResponse = httpClient.execute(httpGet);
            HttpEntity httpEntity = httpResponse.getEntity();

            String response = EntityUtils.toString(httpEntity);

            return new JSONObject(response);

        } catch (Exception e) {
            Log.e("Exception", e.toString());
        }
        return null;
    }

    @Override
    protected void onPostExecute(JSONObject result) {
        super.onPostExecute(result);

        try {
            JSONArray OrderDetailItem = result
                    .getJSONArray("OrderDetailItem");

            for (int i = 0; i < OrderDetailItem.length(); i++) {

                JSONObject jsonObject = OrderDetailItem.getJSONObject(i);

                String order_identifyno = jsonObject
                        .getString("order_identifyno");
                String order_type = jsonObject.getString("order_type");
                String status = jsonObject.getString("status");
                String subTotal = jsonObject.getString("subTotal");

                String t = "order_identifyno : " + order_identifyno
                        + "\norder_type : " + order_type + "\nstatus : "
                        + status + "\nsubTotal : " + subTotal;

                mTextView.setText(t);
            }

            JSONArray OrderFoodItem = result.getJSONArray("OrderFoodItem");

            ArrayList<String> alst = new ArrayList<String>();

            for (int i = 0; i < OrderFoodItem.length(); i++) {

                JSONObject jsonObject = OrderFoodItem.getJSONObject(i);

                String RestaurantPizzaItemName = jsonObject
                        .getString("RestaurantPizzaItemName");
                String quantity = jsonObject.getString("quantity");
                String menuprice = jsonObject.getString("menuprice");

                String s = "RestaurantPizzaItemName : "
                        + RestaurantPizzaItemName + "\nquantity : "
                        + quantity + "\nmenuprice : " + menuprice;

                alst.add(s);
            }

            ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                    MainActivity.this, android.R.layout.simple_list_item_1,
                    alst);

            mListView.setAdapter(adapter);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
}