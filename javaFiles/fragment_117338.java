Map<String, Integer> map = new HashMap<String, Integer>();

for(int i = 0; i < array.length(); i++){
   if(map.get(array[i]) == null){
      map.put(array[i],1);
   }else{
      map.put(array[i], map.get(array[i]) + 1);
   }
}
int largest = 0;
String stringOfLargest;
for (Map.Entry<String, Object> entry : map.entrySet()) {
   String key = entry.getKey();
   int value = entry.getValue();
   if( value > largest){
      largest = value;
      stringOfLargest = key;
   }
}