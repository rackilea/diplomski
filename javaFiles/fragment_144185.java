List<String> out = Lists.transform(in, new Function<String, String>() {

    public String apply(String s) {
        return String.format("(%s)", s);
    }
});