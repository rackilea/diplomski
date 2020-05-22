@Override
    protected void onPostExecute(String s){
        super.onPostExecute(s);

        Log.d("API", "response: " +s);
        if(s == null){
            Toast.makeText(getActivity(), "No response from url", 
        Toast.LENGTH_SHORT).show();
        }
        /* Parsing Code*/
        else {
            try {
                JSONObject obj = new JSONObject(s);
                Gson gson = new Gson();
                GetData itemModel = gson.fromJson(obj.toString(), GetData.class); 
                al.add(itemModel);
                myAdapter.notifyDataSetChanged();
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }