import java.util.HashMap;
import java.util.Map;

interface Space<T> 
{
    void set(long x, long y, T value);
    T get(long x, long y);
}

class DefaultSpace<T> implements Space<T>
{
    private final Map<LongPair, T> map = new HashMap<LongPair, T>();

    @Override
    public void set(long x, long y, T value)
    {
        LongPair key = new LongPair(x,y);
        if (value == null)
        {
            map.remove(key);
        }
        else
        {
            map.put(key, value);
        }
    }

    @Override
    public T get(long x, long y)
    {
        return map.get(new LongPair(x,y));
    }
}


class LongPair
{
    private final long x;
    private final long y;

    LongPair(long x, long y)
    {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString()
    {
        return "("+x+","+y+")";
    }

    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (x ^ (x >>> 32));
        result = prime * result + (int) (y ^ (y >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        LongPair other = (LongPair) obj;
        if (x != other.x)
            return false;
        if (y != other.y)
            return false;
        return true;
    }

}