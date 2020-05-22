public static class JSONPath {

    protected static final JsonFactory JSON_FACTORY = new JsonFactory();

    private final List<JSONKey> keys;

    public JSONPath(final String from) {
        this.keys = Arrays.stream((from.startsWith("[") ? from : String.valueOf("." + from))
                .split("(?=\\[|\\]|\\.)"))
                .filter(x -> !"]".equals(x))
                .map(JSONKey::new)
                .collect(Collectors.toList());
    }

    public Optional<String> getWithin(final String json) throws IOException {
        return this.getWithin(json, false);
    }

    public Optional<String> getWithin(final String json, final boolean strict) throws IOException {
        try (final InputStream stream = new StringInputStream(json)) {
            return this.getWithin(stream, strict);
        }
    }

    public Optional<String> getWithin(final InputStream json) throws IOException {
        return this.getWithin(json, false);
    }

    public Optional<String> getWithin(final InputStream json, final boolean strict) throws IOException {
        return getValueAt(JSON_FACTORY.createParser(json), 0, strict);
    }

    protected Optional<String> getValueAt(final JsonParser parser, final int idx, final boolean strict) throws IOException {
        try {
            if (parser.isClosed()) {
                return Optional.empty();
            }

            if (idx >= this.keys.size()) {
                parser.nextToken();
                if (null == parser.getValueAsString()) {
                    throw new JSONPathException("The selected node is not a leaf");
                }

                return Optional.of(parser.getValueAsString());
            }

            this.keys.get(idx).advanceCursor(parser);
            return getValueAt(parser, idx + 1, strict);
        } catch (final JSONPathException e) {
            if (strict) {
                throw (null == e.getCause() ? new JSONPathException(e.getMessage() + String.format(", at path: '%s'", this.toString(idx)), e) : e);
            }

            return Optional.empty();
        }
    }

    @Override
    public String toString() {
        return ((Function<String, String>) x -> x.startsWith(".") ? x.substring(1) : x)
                .apply(this.keys.stream().map(JSONKey::toString).collect(Collectors.joining()));
    }

    private String toString(final int idx) {
        return ((Function<String, String>) x -> x.startsWith(".") ? x.substring(1) : x)
                .apply(this.keys.subList(0, idx).stream().map(JSONKey::toString).collect(Collectors.joining()));
    }

    @SuppressWarnings("serial")
    public static class JSONPathException extends RuntimeException {

        public JSONPathException() {
            super();
        }

        public JSONPathException(final String message) {
            super(message);
        }

        public JSONPathException(final String message, final Throwable cause) {
            super(message, cause);
        }

        public JSONPathException(final Throwable cause) {
            super(cause);
        }
    }

    private static class JSONKey {

        private final String key;
        private final JsonToken startToken;

        public JSONKey(final String str) {
            this(str.substring(1), str.startsWith("[") ? JsonToken.START_ARRAY : JsonToken.START_OBJECT);
        }

        private JSONKey(final String key, final JsonToken startToken) {
            this.key = key;
            this.startToken = startToken;
        }

        /**
         * Advances the cursor until finding the current {@link JSONKey}, or
         * having consumed the entirety of the current JSON Object or Array.
         */
        public void advanceCursor(final JsonParser parser) throws IOException {
            final JsonToken token = parser.nextToken();
            if (!this.startToken.equals(token)) {
                throw new JSONPathException(String.format("Expected token of type '%s', got: '%s'", this.startToken, token));
            }

            if (JsonToken.START_ARRAY.equals(this.startToken)) {
                // Moving cursor within a JSON Array
                for (int i = 0; i != Integer.valueOf(this.key).intValue(); i++) {
                    JSONKey.skipToNext(parser);
                }
            } else {
                // Moving cursor in a JSON Object
                String name;
                for (parser.nextToken(), name = parser.getCurrentName(); !this.key.equals(name); parser.nextToken(), name = parser.getCurrentName()) {
                    JSONKey.skipToNext(parser);
                }
            }
        }

        /**
         * Advances the cursor to the next entry in the current JSON Object
         * or Array.
         */
        private static void skipToNext(final JsonParser parser) throws IOException {
            final JsonToken token = parser.nextToken();
            if (JsonToken.START_ARRAY.equals(token) || JsonToken.START_OBJECT.equals(token) || JsonToken.FIELD_NAME.equals(token)) {
                skipToNextImpl(parser, 1);
            } else if (JsonToken.END_ARRAY.equals(token) || JsonToken.END_OBJECT.equals(token)) {
                throw new JSONPathException("Could not find requested key");
            }
        }

        /**
         * Recursively consumes whatever is next until getting back to the
         * same depth level.
         */
        private static void skipToNextImpl(final JsonParser parser, final int depth) throws IOException {
            if (depth == 0) {
                return;
            }

            final JsonToken token = parser.nextToken();
            if (JsonToken.START_ARRAY.equals(token) || JsonToken.START_OBJECT.equals(token) || JsonToken.FIELD_NAME.equals(token)) {
                skipToNextImpl(parser, depth + 1);
            } else {
                skipToNextImpl(parser, depth - 1);
            }
        }

        @Override
        public String toString() {
            return String.format(this.startToken.equals(JsonToken.START_ARRAY) ? "[%s]" : ".%s", this.key);
        }
    }
}