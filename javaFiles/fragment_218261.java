import org.json.JSONTokener;
...

URI uri = new URI("http://someserver/data.json");
JSONTokener tokener = new JSONTokener(uri.toURL().openStream());
JSONObject root = new JSONObject(tokener);