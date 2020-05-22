@Override
public <KK extends K, VV extends V> MutableMap<K, V> $plus$plus(Map<KK, VV> map)
{
    HashMap<K, V> copy = this.copy();
    map.$plus$plus$eq(map);
    return copy;
}