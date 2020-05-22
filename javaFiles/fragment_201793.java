public static final void main(final String... args) {

    final Map<String, Integer> map1 = ImmutableMap.of("key0", 2, "key1", 3);

    final Map<String, Integer> map2 = ImmutableMap.of("key0", 2, "key1", 3, "key2", 3);

    final Map<String, Integer> transformed = Maps.transformEntries(map1,
            new EntryTransformer<String, Integer, Integer>() {

                @Override
                public Integer transformEntry(final String key, final Integer value) {

                    return map2.get(key) * value;
                }
            });

    //result {key0=4, key1=9}
    System.out.println(transformed);
}