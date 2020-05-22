queue = new LinkedHashMap<Integer, String>()
  {
     @Override
     protected boolean removeEldestEntry(Entry<Integer, String> eldest)
     {
        return this.size() > yourMaxSize;   
     }
  };