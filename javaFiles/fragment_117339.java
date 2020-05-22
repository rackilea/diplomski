int largest = 0;
for (Map.Entry<String, Object> entry : map.entrySet()) {
   String key = entry.getKey();
   int value = entry.getValue();
   if( value > largest){
      largest = value;
   }
}
ArrayList<Object> arr = new ArrayList<Object>();
for (Map.Entry<String, Object> entry : map.entrySet()) {
   String key = entry.getKey();
   int value = entry.getValue();
   if( value == largest){
       arr.add(key);
   }
}