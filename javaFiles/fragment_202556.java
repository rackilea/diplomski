ArrayList<HashMap<String, String>> items = new ArrayList<HashMap<String, String>>();
JSONObject myJsonObject = new JSONObject(jsonres);
ListView mylv = (ListView) findViewById(R.id.mylvID);
HashMap<String, String> item = new HashMap<String, String>();
Sring id = myJsonObject.getString("id");
String name = myJsonObject.getString("name");
String email = myJsonObject.getString("email");

item.put("id", id);
item.put("name", name);
item.put("email", email);

items.add(item);
String[] keys = {"id", "name", "email"};//our keys for which we take the corresponding value
int[] ids = {R.id.title, R.id.author, R.id.date};

SimpleAdapter adapter = new SimpleAdapter(this, items, R.layout.list_view_item, keys, ids);
mylv.setAdapter(adapter);