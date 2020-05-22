public void onResponse(JSONObject response) {
try {
    JSONArray activities = response.getJSONArray("activities");
    Realm realm = Realm.getDefaultInstance();
    realm.beginTransaction();
    int numOfActivities = activities.length();
    for(int i = 0; i < numOfActivities; i++) {
        JSONObject activity = activities.getJSONObject(i);
        long id = activity.getLong("id");
        if (realm.where(RunSummaryObject.class).equalTo("id", long).findFirst() == null) {
            RunSummaryObject curr = realm.createObject(RunSummaryObject.class);
            curr.setId(activity.getLong("id"));
        }
    }
    realm.commitTransaction();
    realm.close();
} catch (JSONException e) {
    e.printStackTrace();
}