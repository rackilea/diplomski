static void parseJson(String json) throws IOException {

    JsonReader reader = new JsonReader(new StringReader(json));
    reader.setLenient(true);
    while (true) {
        JsonToken token = reader.peek();
        switch (token) {
            case BEGIN_ARRAY:
                reader.beginArray();
                break;
            case END_ARRAY:
                reader.endArray();
                break;
            case BEGIN_OBJECT:
                reader.beginObject();
                break;
            case END_OBJECT:
                reader.endObject();
                break;
            case NAME:
                reader.nextName();
                break;
            case STRING:
                String s = reader.nextString();
                print(reader.getPath(), quote(s));
                break;
            case NUMBER:
                String n = reader.nextString();
                print(reader.getPath(), n);
                break;
            case BOOLEAN:
                boolean b = reader.nextBoolean();
                print(reader.getPath(), b);
                break;
            case NULL:
                reader.nextNull();
                break;
            case END_DOCUMENT:
                return;
        }
    }
}

static private void print(String path, Object value) {
    path = path.substring(2);
    path = PATTERN.matcher(path).replaceAll("");
    System.out.println(path + ": " + value);
}

static private String quote(String s) {
    return new StringBuilder()
            .append('"')
            .append(s)
            .append('"')
            .toString();
}

static final String REGEX = "\\[[0-9]+\\]";
static final Pattern PATTERN = Pattern.compile(REGEX);