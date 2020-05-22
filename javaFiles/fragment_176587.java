class GetProductDetails extends AsyncTask<String, String, JSONObject>
{

    @Override
    protected void onPreExecute() {
        //bla-bla-bla
    }

    protected JSONObject doInBackground(String... args) {
        JSONObject json = null;

        try {
            List<NameValuePair> params = new ArrayList<NameValuePair>();
            params.add(new BasicNameValuePair("pid", pid));

            json = jsonParser.makeHttpRequest(
                    url_product_detials, "GET", params);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return json;
    }

    protected void onPostExecute(JSONObject json) {

        pDialog.dismiss();
        if (json == null) return; // check if json is null too! if null something went wrong (handle it, i used return as example)

        int success = json.getInt(TAG_SUCCESS);;

        if (success == 1) {
            JSONArray productObj = json.getJSONArray(TAG_PRODUCT);
        JSONObject product = productObj.getJSONObject(0);
            txtName = (TextView) findViewById(R.id.tvName);
            txtPrice = (TextView) findViewById(R.id.tvPrice);
            txtDesc = (TextView) findViewById(R.id.tvDescription);
            txtCurrent = (TextView) findViewById(R.id.tvCurrent);
            txtTurn = (TextView) findViewById(R.id.tvTurn);

            txtName.setText(product.getString(TAG_NAME));
            txtPrice.setText(product.getString(TAG_PRICE));
            txtDesc.setText(product.getString(TAG_DESCRIPTION));
            txtCurrent.setText(product.getString("current"));
            txtTurn.setText(product.getString("turn"));

        }else{

        }
    }