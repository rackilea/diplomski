JSONObject main = json.getJSONObject("query").
                getJSONObject("results").getJSONArray("channel");
JSONObject items = main.getJSONObject("item");
JSONObject details = items.getJSONObject("condition");
String t1 = details.getString("text");
String t2 = details.getString("temp");