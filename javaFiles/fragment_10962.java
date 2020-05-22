try {
        JSONArray getArr = object.getJSONArray("checks");

        for (int i = 0; i < getArr.length(); i++) {
            System.out.println("check_id: " + getArr.getJSONObject(i).getString("check_id") + " " + "completed: " + getArr.getJSONObject(i).getBoolean("completed"));
        }
    } catch (JSONException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }