JSONArray jArray= null;
        try {
            jArray = new JSONArray(result);

            for (int i = 0; i < jArray.length(); i++) {

                JSONObject jObject= jArray.getJSONObject(i);
                String status = jObject.getString("Tripname");
                //Log.v("result1", jObject.toString());
                Log.v("Response", status);
            }

        }
        catch (JSONException e)
        {
            e.printStackTrace();
        }