Collections.singletonList(Arrays.asList("a", "b", "c")
    .stream()
    .findAny()
    .orElseThrow(() -> {
        String msg = "Failed";
        return new IllegalArgumentException(msg);
    }));