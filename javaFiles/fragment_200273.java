public void removeNull(Map map) {
   map.values().removeIf(Objects::isNull);
   for (Object value: map.values()) {
       if (value instanceof Map) {
         // Apply a recursion on inner maps
         removeNull((Map) value);
       }
   }
}