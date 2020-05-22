MediaType JSON = MediaType.parse("application/json; charset=utf-8");
    JSONObject parcel = new JSONObject();
    try{
        parcel.put("email", emailEdit.getText().toString());
        parcel.put("password", passwordEdit.getText().toString());
        parcel.put("device", "Android");
        parcel.put("hash", "1234");;
    }catch (JSONException e ){
        e.printStackTrace();
    }
    RequestBody body = RequestBody.create(JSON, parcel.toString());
    Request request = new Request.Builder()
            .header("Content-Type", "application/json")
            .url("YOURURL")
            .post(body)
            .build();
    client.newCall(request).enqueue(new Callback() {
        @Override
        public void onFailure(Call call, IOException e) {
            if (null != e) {e.printStackTrace();}
        }

        @Override
        public void onResponse(Call call, Response response) throws IOException {
            if (null != response && response.message().equals(Constants.KEY_OK)) {
                JSONObject serverResponse;
                try{
                    serverResponse = new JSONObject(response.body().string());
                    if(serverResponse.getBoolean(Constants.KEY_SUCCESS)){
                        Constants.getInstance().setToken(serverResponse.getString(Constants.KEY_TOKEN));
                       moveToHomePage();
                    }else{
                        showLoginFail();
                    }

                }catch (JSONException e ){
                    e.printStackTrace();
                }
                response.body().close();
            } else {
                showLoginFail();
            }
        }
    });