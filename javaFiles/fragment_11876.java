... else if (value.isJsonArray()) {
   final JsonArray jsonArray = value.getAsJsonArray();
   if (jsonArray.size() == 1) {
      runThroughJson(jsonArray.get(0));
   } else {
        // perform some error handling, since
        // you expect it to have just one child!
   }

}