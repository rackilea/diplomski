private final class SaveData extends AsyncTask<JSONArray, Void, Void> {
    protected Void doInBackground(JSONArray... params) {
        int c = section.length();
        for (int i = 0; i < c; i++) {

            try {
                JSONObject obj = section.getJSONObject(i);

                Sections s = new RushSearch().whereEqual("ID", obj.getInt("ID")).findSingle(Sections.class);
                if (s == null) {
                    s = new Sections();
                    s.setID(obj.getInt("ID"));
                }

                if (!obj.isNull("Fk"))
                    s.setFk(obj.getInt("Fk"));

                s.setTitle(obj.getString("Title"));

                if (!obj.isNull("CategoryColor"))
                    s.setCategoryColor(obj.getString("CategoryColor"));

                s.setPos(obj.getInt("Pos"));
                s.setLanguageId(obj.getInt("LanguageId"));
                s.setUnavailableForSend(obj.getBoolean("UnavailableForSend"));

                s.save();

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        Log.d("sections", "DB updated");
        return null;
    }

    public void onPostExecute(Void result) {
        sectionsList = new RushSearch().whereEqual("Fk", 0).find(Sections.class);
        Log.d("ELEMENTI",""+sectionsList.size());
        drawerListViewAdapter = new DrawerListViewAdapter(sectionsList, getApplicationContext());
    }
}