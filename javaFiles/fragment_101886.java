// define AddFieldFn extending from SimpleFunction and overriding apply method
static class AddFieldFn extends SimpleFunction<String, List<String>> {
    @Override
    public List<String> apply(String word) {
        return Arrays.asList(word, "Its weekend!");
    }
}