public <T> Map<String, T> mapMe(Collection<T> list) {
   Map<String, T> map = new HashMap<String, T>();
   for (T el : list) {
       map.put(el.toString(), el);
   }   
   return map;
}