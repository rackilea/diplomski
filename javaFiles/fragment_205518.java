Map<String, String> lastValueView = Maps.transformValues(originalMap,
    new Function<List<String>, String>() {
        @Override
        public String apply(List<String> input) {
            return input.get(input.size() - 1);
        }
    });