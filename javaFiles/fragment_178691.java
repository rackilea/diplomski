public class MainActivityFragment extends Fragment {

private ImageAdapter imageAdapter;

public class FetchMovieTask extends AsyncTask<String, Void, JSONObject> {
    @Override
    protected void onPostExecute(JSONObject strings) {


        Log.i(LOG_TAG, strings.toString());

        try {
            jsonArray = strings.getJSONArray("results");


        if (null != jsonArray) {

            ArrayList<JSONObject> list = new ArrayList<JSONObject>();

            if (jsonArray != null) {
                int len = jsonArray.length();
                for (int i=0;i<len;i++){
                    list.add((JSONObject) jsonArray.get(i));
                }
            }

            imageAdapter = new ImageAdapter(getActivity(), list);
            yourListView.setAdapter(imageAdapter);
        }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
  }
}