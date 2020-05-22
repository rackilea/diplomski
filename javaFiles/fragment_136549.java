public class StringKeyFactory<String> {
    public KeyBuilder<String> newBuilder() {
        return new KeyBuilder<String>() {
            private final StringBuilder s = new StringBuilder();
            public KeySequence<String> append(char value) {
                s.append(value);
                return this;
            }
            public String build() {
                return s.toString();
            }
        };
    }
}