Iterator array = ((JSONArray) parsedJson).iterator();           
while (array.hasNext()) {
    JSONObject json = (JSONObject) array.next();
    JSONArray authors = (JSONArray)json.get("authors");
    JSONIteratorAuthor test = new JSONIteratorAuthor(authors);
    while (test.hasNext()) {
        System.out.println(test.next());
    }
}