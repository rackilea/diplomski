final List<String> strings = Arrays.asList("a", "b", "c");
    final List<Integer> integers = FluentIterable
            .from(strings)
            .transform(new Function<String, Integer>() {
                @Nullable
                @Override
                public Integer apply(@Nullable String input) {
                    return input.equals("a") ? 1 : input.equals("b") ? 2 : input.equals("c") ? 3 : -1;
                }
            })
            .toList();