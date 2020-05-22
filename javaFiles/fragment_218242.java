Iterables.filter(allItems, new Predicate<Map<String, Object>>() {
   @Override public boolean apply(Map<String, Object> map) {
      return Boolean.TRUE.equals(map.get("condition_1"))
         && Boolean.FALSE.equals(map.get("condition_2"));
   }
});