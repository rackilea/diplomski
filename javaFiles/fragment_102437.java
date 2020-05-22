for(JsonElement element : resultArray){
   JsonObject next= element.getAsJsonObject();
   for(Map.Entry<String,JsonElement> entry : next.entrySet()){
     System.out.println(entry.getKey()); // <-- prints out value1 and value2
   }
}