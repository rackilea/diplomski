final class JsonStreams {

    private JsonStreams() {
    }

    static void writeNormalizedJsonStream(final JsonReader reader, final JsonWriter writer)
            throws IOException {
        writeNormalizedJsonStream(reader, writer, true);
    }

    @SuppressWarnings("resource")
    static void writeNormalizedJsonStream(final JsonReader reader, final JsonWriter writer, final boolean isLenient)
            throws IOException {
        int level = 0;
        for ( JsonToken token = reader.peek(); token != null; token = reader.peek() ) {
            switch ( token ) {
            case BEGIN_ARRAY:
                reader.beginArray();
                writer.beginArray();
                ++level;
                break;
            case END_ARRAY:
                reader.endArray();
                writer.endArray();
                if ( --level == 0 && isLenient ) {
                    return;
                }
                break;
            case BEGIN_OBJECT:
                reader.beginObject();
                writer.beginObject();
                ++level;
                break;
            case END_OBJECT:
                reader.endObject();
                writer.endObject();
                if ( --level == 0 && isLenient ) {
                    return;
                }
                break;
            case NAME:
                final String name = reader.nextName();
                writer.name(name);
                break;
            case STRING:
                final String s = reader.nextString();
                writer.value(s);
                break;
            case NUMBER:
                final String rawN = reader.nextString();
                final Number n;
                final Long l = Longs.tryParse(rawN);
                if ( l != null ) {
                    n = l;
                } else {
                    final Double d = Doubles.tryParse(rawN);
                    if ( d != null ) {
                        n = d;
                    } else {
                        throw new AssertionError(rawN); // must never happen
                    }
                }
                writer.value(n);
                break;
            case BOOLEAN:
                final boolean b = reader.nextBoolean();
                writer.value(b);
                break;
            case NULL:
                reader.nextNull();
                writer.nullValue();
                break;
            case END_DOCUMENT:
                // do nothing
                break;
            default:
                throw new AssertionError(token);
            }
        }
    }

}