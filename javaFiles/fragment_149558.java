private Iterator<JSONObject> authors;

@SuppressWarnings("unchecked")
public JSONIteratorAuthor(JSONArray array){
   authors = array.iterator();
}

@Override
public boolean hasNext() {
   return authors.hasNext();
}

@Override
public Author next() {
   if (hasNext()) {
       Author a = new Author(0, "", "");
       JSONObject authorNode = authors.next();
       a.setFirstName((String) authorNode.get("first_name"));
       a.setLastName((String) authorNode.get("last_name"));
       return a;
   }
   else {
       return null;
   }
}