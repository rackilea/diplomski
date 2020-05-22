JSONObject store = new JSONObject(response);
if(store.has("CreatedOn")) {
  Timestamp stamp = new Timestamp(store.getLong("CreatedOn"));
  Date date = new Date(stamp.getTime());
  System.out.println(date);
}