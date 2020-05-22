@Override
    public void onResponse(String response) {
        try {
            Log.i(TAG, response);
            JSONArray foodResp = new JSONArray(response);
            for (int i = 0; i < foodResp.length(); i++) {
                JSONObject foodObj = foodResp.getJSONObject(i);
                foodList.add(
                        new Food(
                                1,
                                R.drawable.ic_launcher_background,
                                foodObj.getString("mealTitle"),
                                foodObj.getString("mealDesc"))
                );
            }
         if(adapter!=null)
        {
          adapter.notifyDataSetChanged();
        }
        } catch (Exception e) {
            Log.i(TAG, "Error: " + e.getMessage());
        }

    }