private class GetBotResponse extends AsyncTask<String, Void, JSONObject>{


@Override
protected JSONObject doInBackground(String... params) {
    // TODO Auto-generated method stub
    JSONObject json = jParser.getJSONFromUrlByGet(params[0]);

    return json;
}

@Override
protected void onPostExecute(JSONObject json) {
if(json!=null)
{
   try {

        String str_usersay = json.getString(TAG_USERSAY);

        Log.i("TAG_usersay", str_usersay);
        String str_botsay = json.getString(TAG_BOTSAY);

        Log.i("TAG_botsay", str_botsay);
        String str_convo_id = json.getString(TAG_CONVO_ID);

        Log.i("TAG_convo_id", str_convo_id);
    } catch (JSONException e) {
    }
   }
    tv.setText(str_botsay);

    }

   }