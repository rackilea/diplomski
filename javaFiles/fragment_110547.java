JSONObject json = new JSONObject(s);
Iterator iterator = json.keys();

while( iterator.hasNext() ){
  String data = iterator.next();
  //filter and or business logic
}