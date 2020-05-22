JSONObject store = new JSONObject(response);
if(store.has("CreatedOn")) {
Integer datetimestamp = Integer.parseInt(store.getString("CreatedOn").replaceAll("\\D", ""));
 Date date = new Date(datetimestamp);
 DateFormat formatter = new SimpleDateFormat("HH:mm:ss:SSS");
 String dateFormatted = formatter.format(date);
}