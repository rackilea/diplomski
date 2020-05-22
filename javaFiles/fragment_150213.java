Map<String, Integer> map = Collections.synchronizedMap(new LinkedHashMap<String, Integer>() {
   private static final long serialVersionUID = 12345L; // use something random or just suppress the warning
   @Override
   protected boolean removeEldestEntry(Entry<String, Integer> eldest) {
      return size() > MAX_SIZE; // how many entries you want to keep
   }               
});