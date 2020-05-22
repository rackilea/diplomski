String json = "['1','notification 1','hello','first notification','2015-07-23','2015-07-30','www.google.com','2','notification 2','hello2','second notification','2015-07-23','2015-07-28','www.yahoo.com']";
JSONArray jArray = json.getJSONArray(json);
ArrayList<String> = new ArrayList<String>(jArray.length());
for (int i = 0; i < jArray.length(); i++) {
    arrayList.add(jArray.getString(i));
}