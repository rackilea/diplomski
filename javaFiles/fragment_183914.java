ImmutableListMultimap<String, Foo> grouped = MultiMaps.index(list,
    new Function<Foo, String>() {
        public String apply(Foo input) {
            return input.getType();
        }
});