final private Map<T, T> values = new HashMap<T, T>(); 
public T findCanonicalValue(T value)
{
    T canon = this.values.get(value);
    if (canon == null)
    {
       // not in the set, so put it there for the future
       this.values.put(value, value);
       return value;
    }
    else
    {
       // in the set
       return canon;
    }
}