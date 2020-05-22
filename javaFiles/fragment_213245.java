public static void incr()
{
    synchronized(map) {map.merge("counter", 1, Integer::sum);}
}

public static void decr()
{
    synchronized(map) {map.merge("counter", -1, Integer::sum);}
}