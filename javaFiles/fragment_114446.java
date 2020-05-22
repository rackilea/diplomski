private static Function<T, String> NAME_EXTRACTOR = 
    new Function<T, String>() {
        @Override public String apply(T input) {
            return input.getName();
        }
    };

...

joinOnMethod(", ", someList, NAME_EXTRACTOR);