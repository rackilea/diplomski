import com.loopj.android.http.*;

AsyncHttpClient client = new AsyncHttpClient();
    client.get("your url", new AsyncHttpResponseHandler() {
        @Override
        public void onSuccess(String response) {
            System.out.println(response);
          try {
            JSONObject json = new JSONObject(result);
            JSONArray jArr = json.getJSONArray("content");
           if(jArr.length>0)
           {
                 JSONObject jobj =jArr.getJSONObject(0);
                 String username=jobj.getString("username");
                 String pass=jobj.getString("password");
                 usernameEditText.setText(str);
                passwordEditText.setText(str);
           }
       } catch (JSONException e) {

        e.printStackTrace();
    }

    });