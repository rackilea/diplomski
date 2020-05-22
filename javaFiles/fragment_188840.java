String s; // declare this globally

public  void  setTextToTextView(JSONArray jsonArray) {

    for (int i = 0; i < jsonArray.length(); i++) {

        JSONObject json = null;
        try {
            json = jsonArray.getJSONObject(i);
            s = s + json.getString("adUrl");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    this.responseTextView.setText(s);

}

public void gotosite(View v) {

   s=responseTextView.getText().toString(); // either use this or you can now use string s directly 

        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://"+s+""));
        startActivity(i);

    }