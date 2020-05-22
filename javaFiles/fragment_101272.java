interface Options<K, V>
{
    Options<K, V> add(K key, V value);
    Options<K, V> add(Options<K, V> otherOptions);
}

Options<String, String> options = /*whatever*/;
List<Pair<String, String>> elems = /*whatever*/;

Options<String, String> foo = elems.stream()
    .reduce(
        options,
        (opt, pair) -> opt.add(pair.getKey(), pair.getValue()),
        Options::add
    );