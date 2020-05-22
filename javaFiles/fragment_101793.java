import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class EvictionList<K>

{

private final ConcurrentHashMap<K, Long> evictionList = new ConcurrentHashMap<K, Long>();
private long evictionTime;
private final EvictionThread t;
public EvictionList(int evictionTimeInSeconds)
{
    this.evictionTime = evictionTimeInSeconds * 1000;
    t = new EvictionThread(this, evictionTime);
    Thread thread = new Thread(t);
    thread.start();
}

public void touch(K o)
{
    evictionList.put(o, System.currentTimeMillis());
}

public void evict()
{
    long current = System.currentTimeMillis();
    for (Iterator<K> i=evictionList.keySet().iterator(); i.hasNext();)
    {
        K k = i.next();
        if (current > (evictionList.get(k) + evictionTime) )
        {
            i.remove();
        }
    }
}

public void setEvictionTime(int timeInSeconds)
{
    evictionTime = timeInSeconds * 1000;
    t.setEvictionTime(evictionTime);
}

public Set<K> getKeys()
{
    return evictionList.keySet();
}

public void stop()
{
    t.shutDown();
}

@Override
protected void finalize()
{
    t.shutDown();   
}

private class EvictionThread implements Runnable
{
    private volatile long evictionTime;
    private EvictionList list;
    private volatile boolean shouldRun = true;

    private EvictionThread(EvictionList list, long evictionTime)
    {
        this.list = list;
        this.evictionTime = evictionTime;
    }

    public void shutDown()
    {
        shouldRun = false;
    }

    public void setEvictionTime(long time)
    {
        evictionTime = time;
    }

    public void run()
    {
        while (shouldRun)
        {
            try
            {
                Thread.sleep(evictionTime);
            }
            catch (Exception ex) {}
            list.evict();
        }
    }
}