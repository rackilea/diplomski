String jsonData = sb.toString();
JSONObject obj = new JSONObject(jsonData);

JSONArray resultsArr = obj.getJSONArray("results");
String test = resultsArr.getJSONObject(0).toString();

JSONArray lexicalEntriesArr = resultsArr.getJSONObject(0).getJSONArray("lexicalEntries");
JSONArray entriesArr = lexicalEntriesArr.getJSONObject(0).getJSONArray("entries");
JSONArray sensesArr = entriesArr.getJSONObject(0).getJSONArray("senses");
JSONArray definitionsArr = sensesArr.getJSONObject(0).getJSONArray("definitions");

String definition = definitionsArr.toString();