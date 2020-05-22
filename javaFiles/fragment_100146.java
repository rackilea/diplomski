private Multimap<Boolean, String> reverseMap(Map<String, Boolean> permissions) {
   Multimap<Boolean, String> multimap = ArrayListMultimap.create();
   for (Map.Entry<String, Boolean> entry : permissions.entrySet()) {
      multimap.put(entry.getValue(), entry.getKey());
   }
   return multimap;
}