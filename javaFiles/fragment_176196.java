// This loop looks wrong at the moment - you're not using i
for (int i = 0; i < json.Length(); i++) {
     HashMap<String, String> map = new HashMap<String, String>();
     // adding each child node to HashMap key => value
     map.put(KEY_ID, json.getString("id"));
     map.put(KEY_TITLE, json.getString("title"));
     map.put(KEY_AUTHOR, json.getString("author"));
     map.put(KEY_DATE, json.getString("date"));
     booksList.add(map);
}

for (Map<String, String> map : booksList) {
     arrTitles.add(map.get(KEY_TITLE));
     arrAuthors.add(map.get(KEY_AUTHOR));
     arrDates.add(map.get(KEY_DATE));
}