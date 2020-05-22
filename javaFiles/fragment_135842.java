int bar = foo(Arrays.asList("test"), new ToIntFunction<String>() {
    @Override
    public int applyAsInt(String value) {
        return value.length();
    }
});