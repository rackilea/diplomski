for (Map<String, String> map : listOfMap) {
   for(Entry<String, String> entry : map.entrySet()) {
     System.out.println(entry.getKey());
     System.out.println(entry.getValue());
   }
}