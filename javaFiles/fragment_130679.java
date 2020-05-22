Map<Indentifer, Object> map...;
   Object value = map.get(id);

   // or as of Java 8+

   Object value = map.getorDefault(id, someDefaultValue);