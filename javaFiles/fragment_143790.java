private void JsonRequestGraph() {

    utils.showDialog();

    String url = Constants.TOP_10_BOUQUIT+"days="+time+"&warehouse_id="+whareHouse;
    Log.e("URL", "" + url);

    JsonObjectRequest request = new JsonObjectRequest(url, null,
            response -> {
                Log.e("onResponse",""+response);
                try {

                    Gson gson = new Gson();
                    Type listType = new TypeToken<HighVelocityPojo>() {
                    }.getType();

                    HighVelocityPojo highVelocityPojo = gson.fromJson(response.toString(), listType);
                    Log.e("size", highVelocityPojo.getSKU().size() + "");

                    callGraphView();

                } catch (Exception e) {
                    Log.e("Exception",""+e);
                    utils.hideDialog();
                    e.printStackTrace();

                }
               utils.hideDialog();

            }, error -> {

                Log.e("error",""+error.getMessage());
                utils.hideDialog();
            });
    request.setRetryPolicy(new DefaultRetryPolicy(
            MY_SOCKET_TIMEOUT_MS,
            DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
            DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
    AppController.getInstance(getContext()).addToRequestQueue(request);

}