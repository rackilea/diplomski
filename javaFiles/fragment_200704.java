String s = "[{\"index\":1,\"questions\":\"If the number of berths in a train are 900 more than one-fifth of it, find the total berths in the train?\",\"options\":[\"1145\",\"1130\",\"1135\",\"1125\",\"1120\"],\"answers\":\"1125\",\"useranswers\":\"1145\"}]";
        try {
            JSONArray a;
            a = new JSONArray(s);
            JSONObject o = (JSONObject) a.get(0);
            JSONArray options = o.getJSONArray("options");
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }