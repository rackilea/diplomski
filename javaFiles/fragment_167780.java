class LoadContentFromServer extends AsyncTask<Object, Integer, Object> {

    @Override
    protected Object doInBackground(Object... params) {

        String url = "http://..no looking..";

        JSONObject data;
        try {

            data = new JSONObject(getJSONUrl(url));
            Log.v("data", data.toString());
            JSONArray dataArray = data.getJSONArray("car_images");

                /*
                 * TotalRows = Show for total rows
                 * TotalPage = Show for total page
                 */

            int displayPerPage = 9;   // Per Page
            int TotalRows = data.length();
            int indexRowStart = ((displayPerPage * currentPage) - displayPerPage);

            if (TotalRows <= displayPerPage) {
                TotalPage = 1;
            } else if ((TotalRows % displayPerPage) == 0) {
                TotalPage = (TotalRows / displayPerPage);
            } else {
                TotalPage = (TotalRows / displayPerPage) + 1;
                TotalPage = (int) TotalPage;
            }
            int indexRowEnd = displayPerPage * currentPage;
            if (indexRowEnd > TotalRows) {
                indexRowEnd = TotalRows;
            }

            for (int i = 0; i < dataArray.length(); i++) {
                //HashMap<String, Object> map = new HashMap<String, Object>();
                JSONObject c = dataArray.getJSONObject(i);
                Log.v("getJSONObject(i)", dataArray.getJSONObject(i).toString());

                // Thumbnail Get ImageBitmap To Object
                HashMap<String, Object> map = new HashMap<String, Object>();
                Bitmap bitmap = loadBitmap(c.getString(TAG_IMG));
                Drawable d = new BitmapDrawable(getResources(), bitmap);
                map.put(TAG_IMG, d);
                Log.v("Bitmap", TAG_IMG);

                MyArrList.add(map);
                Log.v("MyArrList", MyArrList.toString());
                Log.v("return0", MyArrList.toString());
            }

        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Object result) {

        Log.v("return3", MyArrList.toString());
        // Disabled Button Next
        if(currentPage >= TotalPage) {
            btnNext.setEnabled(false);
        }
        else {
            btnNext.setEnabled(true);
        }

        // Disabled Button Previous
        if(currentPage <= 1) {
            btnPre.setEnabled(false);
        }
        else {
            btnPre.setEnabled(true);
        }
        setProgressBarIndeterminateVisibility(false);
        imageAdapter.addAll(MyArrList);
        imageAdapter.notifyDataSetChanged();
        Log.v("return2", imageAdapter.toString());
        Log.v("return2.1", MyArrList.toString());
    }
}