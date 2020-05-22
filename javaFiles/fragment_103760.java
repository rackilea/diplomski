httpConnect jParser = new httpConnect();
JSONObject json1obj = new JSONObject(jParser.getJSONFromUrl(url));
JSONArray json1arr = json1obj.getJSONArray("results");
List<String> posterPaths = new ArrayList<String>(json1arr.length());  
for (int i = 0 ; i < json1arr.length(); i++) {
    JSONObject ithObject = json1arr.getJSONObject(i);
    // if necessary, check to make sure the key 'poster_path' exists
    if (ithObject.has("poster_path")) {
        posterPaths.add(ithObject.getString("poster_path"));
    }
}

// as an example usage, loop through the list and print each poster path
for (String posterPath : posterPaths) {
    System.out.println(posterPath);
}