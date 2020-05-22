public class MyFirstClassImpl<K extends Comparable<K>, V> extends MyFirstClass<K,V>
{
    @Override
    public Iterator<MySecondClass<K, V>> iterator()
    {
    // Code
    }
}