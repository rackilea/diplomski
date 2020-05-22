public static <K,V> Map<K,V> create( Class<V> cl )
{
    return new HashMapSafe<K,V>(cl);
}

...

Map<String,Section> sections = HashMapSafe.create(Section.class);