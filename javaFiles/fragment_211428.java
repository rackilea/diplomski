private Map cache = new LinkedHashMap(max_cache, .75F, true) {
    protected boolean removeEldestEntry(Map.Entry eldest) {
       // Pseudo-Code 
       if(this.size() > MAX_CACHE_SIZE){
           FileOutputStream fos = new FileOutputStream("t.tmp");
           ObjectOutputStream oos = new ObjectOutputStream(fos);

           oos.writeObject(eldest.getValue());
           return true;
       } finally {
           oos.close();
           fos.close();
       }

       return false;
    }
};