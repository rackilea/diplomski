static ConcurrentMap syncMap = new ConcurrentHashMap();

public void report()
{
   String clientIp =  ...
   syncMap.putIfAbsent(clientIp, new Object()); // just new Object is good enough to sync on
   synchronized(syncMap.get(clientIp))
   {
      //do synchronized stuff.
   }
}