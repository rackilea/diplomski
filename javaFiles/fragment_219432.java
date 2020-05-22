private String implode(String delimiter, Map<String, String> map){

   boolean first = true;
   StringBuilder sb = new StringBuilder();

   for(Entry<String, String> e : map.entrySet()){
      if (!first) sb.append(" "+delimiter+" ");
      sb.append(" " + e.getKey() + " = '" + e.getValue() + "' ");
      first = false;
   }

   return sb.toString();
}