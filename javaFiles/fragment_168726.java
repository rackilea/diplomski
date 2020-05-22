public class MainActivity extends Activity implements onResponse {

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    String URL = "http://www.gw2spidy.com/api/v0.9/json/item-search/Sunrise";
    AsyncFetch parkingInfoFetch = new AsyncFetch(this);
    parkingInfoFetch.setOnResponse(this);
    parkingInfoFetch.execute(URL);
}

@Override
public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.activity_main, menu);

    return true;
}

@Override
public void onResponse(JSONObject object) {
    Log.d("Json Response", "Json Response" + object);

    ResultClass resultClass = new ResultClass();

    try {
        resultClass.setCount(object.getInt("count"));
        resultClass.setPage(object.getInt("page"));
        resultClass.setLast_page(object.getInt("last_page"));
        resultClass.setTotal(object.getInt("total"));
        JSONArray array = new JSONArray(object.getString("results"));
        for (int i = 0; i < resultClass.getTotal(); i++) {
            JSONObject resultsObject = array.getJSONObject(i);
            resultClass.setData_id(resultsObject.getInt("data_id"));
            resultClass.setName(resultsObject.getString("name"));
            resultClass.setRarity(resultsObject.getInt("rarity"));
            resultClass.setRestriction_level(resultsObject
                    .getInt("restriction_level"));
            resultClass.setImg(resultsObject.getString("img"));
            resultClass.setType_id(resultsObject.getInt("type_id"));
            resultClass.setSub_type_id(resultsObject.getInt("sub_type_id"));
            resultClass.setPrice_last_changed(resultsObject
                    .getString("price_last_changed"));
            resultClass.setMax_offer_unit_price(resultsObject
                    .getInt("max_offer_unit_price"));
            resultClass.setMin_sale_unit_price(resultsObject
                    .getInt("min_sale_unit_price"));
            resultClass.setOffer_availability(resultsObject
                    .getInt("offer_availability"));
            resultClass.setSale_availability(resultsObject
                    .getInt("sale_availability"));
            resultClass.setSale_price_change_last_hour(resultsObject
                    .getInt("sale_price_change_last_hour"));
            resultClass.setOffer_price_change_last_hour(resultsObject
                    .getInt("offer_price_change_last_hour"));

        }

    } catch (JSONException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }

}}