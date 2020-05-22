public static void getitemCountPrice(String cartId, APIListener apiListener) {

        try {
            if (Utils.isNetworkAvailable(mContext)) {
                HashMap<String, String> params = new HashMap<>();
                params.put(CONSTANTS.API_param_cartid, cartId);
                params.put(CONSTANTS.API_param_token, Utils.getToken());
                JSONObject postdata = new JSONObject(params);

                try {
                    YupITApplication.getJsonWithHTTPPostResponse(params, mContext, 1, (id, jsonResult) -> {
                        if (jsonResult.getString(mContext.getString(R.string.status)).equalsIgnoreCase(mContext.getString(R.string.success))) {
                            itemCountPrice = jsonResult.getJSONObject("Data").getString("Count") + ","
                                    + jsonResult.getJSONObject("Data").getString("TotalPrice");
                            Log.e("itemCountPrice.............", "" + itemCountPrice);
    apiListener.onResponse(itemCountPrice);
                            // Here I get value
                        } else {
                            itemCountPrice = "0,0";
                            apiListener.onResponse(itemCountPrice);
                        }
                    }, Utils.cartitemcount, postdata);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                Toast.makeText(mContext, mContext.getString(R.string.no_server_found), Toast.LENGTH_SHORT).show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }