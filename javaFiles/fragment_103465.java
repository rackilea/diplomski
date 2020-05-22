public static void main(String[] args)
{
    for(int i = 0; i<100; i++)
    {
        System.out.println();

        int entries = i*100*1000;
        long t0=test( entries, new FakeMap() );
        long t1=test( entries, new HashMap() );
        long t2=test( entries, new ConcurrentHashMap() );

        long diff = (t2-t1)*100/(t1-t0);
        System.out.printf("entries=%,d time diff= %d%% %n", entries, diff);
    }
}


static long test(int ENTRIES, Map map)
{
    long SEED = 0;
    Random random = new Random(SEED);

    int RW_RATIO = 10;

    long t0 = System.nanoTime();

    for(int i=0; i<ENTRIES; i++)
        map.put( random.nextInt(), random.nextInt() );

    for(int i=0; i<RW_RATIO; i++)
    {
        random.setSeed(SEED);
        for(int j=0; j<ENTRIES; j++)
        {
            map.get( random.nextInt() );
            random.nextInt();
        }
    }
    long t = System.nanoTime()-t0;
    System.out.printf("%,d ns %s %n", t, map.getClass());
    return t;
}


static class FakeMap implements Map
{
    public Object get(Object key)
    {
        return null;  
    }
    public Object put(Object key, Object value)
    {
        return null;  
    }
    // etc. etc.
}