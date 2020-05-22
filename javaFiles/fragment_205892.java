Collection<Map<String, Object>> filteredList = Collections2.filter(
    maps, new Predicate<Map<String, Object>>() {
      @Override
      public boolean apply(@Nullable Map<String, Object> map) {
        return (Integer) map.get("ID") >= 1 && !"cc".equals(map.get("Name"));
      }
    });