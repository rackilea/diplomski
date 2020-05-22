try {
    String ret = download("http://www.omdbapi.com/?i=tt2975590&plot=full&r=json");

    if (ret != null) {

        JSONObject items = new JSONObject(ret);
        Iterator x = items.keys();
        JSONArray jsonArray = new JSONArray();

        while (x.hasNext()) {
            String key = (String) x.next();
            jsonArray.put(items.get(key));
            System.out.println(key + " : " + items.get(key));
        }
    }

} catch (IOException e) {
    e.printStackTrace();
} catch (JSONException e) {
    e.printStackTrace();
}