public static void main(String[] args) {
    class CacheMap extends LinkedHashMap{
      private int maxCapacity;
      public CacheMap(int initialCapacity, int maxCapacity) {
        super(initialCapacity, 0.75f, true);
        this.maxCapacity = maxCapacity;
      }

      @Override
      protected boolean removeEldestEntry(Map.Entry eldest) {
        return size()>maxCapacity;
      }
    }

    int[] popular = {1,2,3,4,5};
    CacheMap myCache = new CacheMap(5, 10);
    for (int i=0; i<100; i++){
      myCache.put(i,i);
      for (int p : popular) {
        myCache.get(p);
      }
    }

    System.out.println(myCache.toString()); 
    //{95=95, 96=96, 97=97, 98=98, 99=99, 1=1, 2=2, 3=3, 4=4, 5=5}
  }