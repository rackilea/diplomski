class Callables {

    @PatternHandler("foo")
    public static final TownyChatReplacerCallable FOO = new TownyChatReplacerCallable() {
        @Override
        public String call(String match, String event) {
            return "This is foo handler called with " + match + "," + event;
        }
    };

    @PatternHandler("bar")
    public static final TownyChatReplacerCallable BAR = new TownyChatReplacerCallable() {
        @Override
        public String call(String match, String event) {
            return "This is foo handler called with " + match + "," + event;
        }
    };
}