ListView listView = (ListView) findViewById(R.id.listView1);
list = new ArrayList<HashMap<String, String>>();
for (int i=0; i<result.length(); i++) {
    JSONObject notice = result.getJSONObject(i);
    id[i] = notice.getString(KEY_ID);
    name[i] = notice.getString(KEY_NAME);
    date_from[i] = notice.getString(KEY_DATE_FROM);
    date_to[i] = notice.getString(KEY_DATE_TO);

    HashMap<String, String> temp= new HashMap<String, String>();
    temp.put(FIRST_COLUMN, id[i]);
    temp.put(SECOND_COLUMN, name[i]);
    temp.put(THIRD_COLUMN, date_from[i]);
    temp.put(FOURTH_COLUMN, date_to[i]);
    list.add(temp);
}
    ListViewAdapters adapter = new ListViewAdapters(this, list);
    listView.setAdapter(adapter);